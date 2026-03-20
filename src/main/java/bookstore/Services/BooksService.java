package bookstore.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bookstore.Entity.*;
import bookstore.Repository.BooksRepository;
@Service
public class BooksService {

	
@Autowired
 BooksRepository booksRepository;




public List<BooksEntity> getAllbooks(){
	return booksRepository.findAll();
}
public Optional<BooksEntity> getbooksById(Long Id){
	return booksRepository.findById(Id);
}
public List<BooksEntity> getbooksBycategory(String category){
	return booksRepository.findByCategory(category);
}
}
