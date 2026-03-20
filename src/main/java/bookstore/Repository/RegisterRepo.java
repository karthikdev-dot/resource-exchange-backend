package bookstore.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookstore.Entity.Registerentity;

@Repository

public interface RegisterRepo extends JpaRepository<Registerentity, Long>{
	
	 Optional<Registerentity>findByUsername(String username);
}
