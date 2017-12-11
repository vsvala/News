
package wad.controller;
 
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kategoriat;
import wad.domain.Uutinen;
import wad.repository.KategoriatRepository;
import wad.repository.UutinenRepository;

 
@Service
public class UutinenService  {
 
    @Autowired
    private UutinenRepository uutinenRepository;
    @Autowired
    private KategoriatRepository kategoriatRepository;
 
    public List<Uutinen> list() {
        return uutinenRepository.findAll();
    }
 
   @Transactional
    public void add(String name, String ingres, String sisalto, String kuva, String kirjoittaja, String kategori) {
       
        Uutinen eka = new Uutinen();
        eka.setIngres(ingres);
        eka.setSisalto(sisalto);
        eka.setKuva(kuva);
        eka.setAika(LocalDateTime.now());
        eka.setKirjoittaja(kirjoittaja);
        Kategoriat kategoria = new Kategoriat();   
        kategoria.setName(kategori);
        eka.setKategoria(kategoria);
        
        //eka.setKirjoittajat(new Kirjoittaja(kirjoittaja));
        //eka.setKategoria(new Kategoriat(kategori)); 
       // kategoria.getUutiset().add(eka);
        kategoriatRepository.save(kategoria);
        uutinenRepository.save(eka);
         
    }  
 
    @Transactional
    public void addUutinenToKategory(Long uutinenId, Long kategoriaId, @RequestParam String kategori) {
        Uutinen uutinen = uutinenRepository.getOne(uutinenId);
        Kategoriat kategoria= kategoriatRepository.getOne(kategoriaId);
 
        
        uutinen.setKategoria(kategoria);
        kategoria.getUutiset().add(uutinen);
        

//             kategoriatRepository.save(kategoria);
//             uutinenRepository.save(uutinen);
    }
    
    public Uutinen findById(Long uutinenId) {
        return uutinenRepository.getOne(uutinenId);
   
}
    public Kategoriat findKAtegoriaById(Long kategoriaId) {
    return kategoriatRepository.getOne(kategoriaId);
   
}
}

