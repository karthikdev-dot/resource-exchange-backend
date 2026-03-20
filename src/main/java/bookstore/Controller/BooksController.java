package bookstore.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bookstore.Entity.BooksEntity;
import bookstore.Services.BooksService;
@RestController
@RequestMapping("/books")
public class BooksController {
@Autowired
BooksService booksService;

@GetMapping
public List<BooksEntity> getallBooks(){
	return booksService.getAllbooks();
}
@GetMapping("/category/{category}")
public List<BooksEntity> getbooksByCategory(@PathVariable String category){
	return booksService.getbooksBycategory(category);
}
@GetMapping("/{Id}")
public ResponseEntity<BooksEntity>getbooksById(@PathVariable Long Id){
	return booksService.getbooksById(Id).map(ResponseEntity::ok)                     
            .orElse(ResponseEntity.notFound().build());
}
}


