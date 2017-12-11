
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
    public void add(String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori, Kategoriat kategoria) {
          Uutinen eka = new Uutinen();
        eka.setName(name);
        eka.setIngres(ingres);
        eka.setSisalto(sisalto);
        eka.setKuva(kuva);
        eka.setAika(LocalDateTime.now());
        eka.setKirjoittajat(kirjoittajat);
        eka.setKategoria(new Kategoriat(kategori));
        kategoriatRepository.save(kategoria);
        uutinenRepository.save(eka);
         
    }
    
//        @PostMapping("/")
//    public String createUutinen(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori, Kategoriat kategoria){
//
//        Uutinen eka = new Uutinen();
//        eka.setName(name);
//        eka.setIngres(ingres);
//        eka.setSisalto(sisalto);
//        eka.setKuva(kuva);
//        eka.setAika(LocalDateTime.now());
//        eka.setKirjoittajat(kirjoittajat);
//        eka.setKategoria(kategoria); 
//        kategoriatRepository.save(kategoria);
//        uutinenRepository.save(eka);
//                                     
//        //eka = uutinenRepository.getOne(uutinenId);
//       // kategoria = kategoriatRepository.getOne(kategoriaId);
//        eka.setKategoria(kategoria); 
//     //tähän if lause tsekkaan onko kategoria jo olemassa,,,,ja lisöö jos ei ,,
//        kategoria.setName(kategori);
//       // kategoria.addUutinen(eka);
//       // kategoria.setName("kulttuuri");
//             kategoriatRepository.save(kategoria);
//             uutinenRepository.save(eka);
//   
//        return "redirect:/";                   //  "redirect:/";  samalle sivulle
//    }
//    
 
    @Transactional
    public void addUutinenToKategory(Long uutinenId, Long kategoriaId, @RequestParam String kategori) {
        Uutinen uutinen = uutinenRepository.getOne(uutinenId);
        Kategoriat kategoria= kategoriatRepository.getOne(kategoriaId);
 
        uutinen.getKategoria().setName(kategori);
        kategoria.getUutiset().add(uutinen);
        
//        eka.setKategoria(kategoria); 
//     //tähän if lause tsekkaan onko kategoria jo olemassa,,,,ja lisöö jos ei ,,
//        kategoria.setName(kategori);
//       // kategoria.addUutinen(eka);
//       // kategoria.setName("kulttuuri");
//             kategoriatRepository.save(kategoria);
//             uutinenRepository.save(eka);
    }
 
    public Uutinen findById(Long uutinenId) {
        return uutinenRepository.getOne(uutinenId);
   
}
    public Kategoriat findKAtegoriaById(Long kategoriaId) {
    return kategoriatRepository.getOne(kategoriaId);
   
}
}

