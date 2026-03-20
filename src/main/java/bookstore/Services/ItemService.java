package bookstore.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.DTOs.ItemResponseDto;
import bookstore.DistanceCalculation.DistanceCalculation;
import bookstore.Entity.Item;
import bookstore.Entity.Registerentity;
import bookstore.Repository.ItemRepo;
import bookstore.Repository.RegisterRepo;

@Service
public class ItemService {

    @Autowired
    private ItemRepo repo;
    @Autowired
    RegisterRepo reg;

	
    public Item saveItem(Item item) {

        Long userId = item.getUser().getId();

        Registerentity user = reg.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        item.setUser(user);   // ⭐ MUST
        return repo.save(item);
    }
    
    
   
    private static final double AVERAGE_DISTANCE_KM = 5.0;

    public List<ItemResponseDto> GetData(String searchText,
                                         Double userLat,
                                         Double userLon) {

        List<Item> items =
                repo.findByItemNameContainingIgnoreCaseAndAvailableTrue(searchText);

        System.out.println("SearchText = " + searchText);
        System.out.println("Items found from DB = " + items.size());

        return items.stream()
                .map(item -> {

                    if (item.getItemlatitude() == null || item.getItemlongitude() == null) {
                        return null;
                    }

                    double distance = DistanceCalculation.distance(
                            userLat,
                            userLon,
                            item.getItemlatitude(),
                            item.getItemlongitude()
                    );

                    if (distance > AVERAGE_DISTANCE_KM) {
                        return null;
                    }

                    return new ItemResponseDto(
                            item.getItemName(),
                            item.getPrice(),
                            item.getUser().getUsername(),
                            item.getItemlatitude(),
                            item.getItemlongitude(),
                            distance   // ✅ Added distance
                    );
                })
                .filter(dto -> dto != null)   // remove null values
                .sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .toList();
    }
}