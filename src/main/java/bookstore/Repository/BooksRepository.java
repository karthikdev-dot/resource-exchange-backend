package bookstore.Repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookstore.Entity.*;

@Repository

	public interface BooksRepository extends JpaRepository<BooksEntity,Long>{
	
  List<BooksEntity> findByCategory(String category);
		
	
}


