package wad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wad.domain.Kategoriat;

public interface KategoriatRepository extends JpaRepository<Kategoriat, Long > {
     //   Kategoriat findBy(Long id); //ei toimi 
//    List<Kategoriat> findByNimi(String nimi);
//        @Query("SELECT h FROM kategoria h WHERE h.nimi = 'kulttuuri'")
//    Kategoriat findJackBauer();
}