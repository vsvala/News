package wad.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Uutinen;

public interface UutinenRepository extends JpaRepository<Uutinen, Long > {
 // Uutinen findByUutinenId(Long uutinenId);
    // Uutinen findById(Long id); 
//List<Uutinen> findBytime(String name, String ingres, String kuva, LocalDate aika, Pageable pageable);
//List<Uutinen> findBykategoria(String kategoria);
// List<Uutinen> findByNameAndDate(String name, LocalDate time);
    
}
