package bookstore.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import bookstore.Entity.Item;

public interface ItemRepo extends JpaRepository<Item, Long>{

	List<Item>findByItemNameContainingIgnoreCaseAndAvailableTrue(String itemName);
}

