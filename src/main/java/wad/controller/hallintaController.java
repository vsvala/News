package wad.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Uutinen;
import wad.repository.UutinenRepository;

@Controller
public class hallintaController {

//    @Autowired
//    private UutinenService uutinenService;
//    
    @Autowired
    private UutinenRepository uutinenRepository;

    @GetMapping("/")
    public String list(Model model) {
        if (uutinenRepository.findAll().isEmpty()) {//size o null?
            Uutinen malli = new Uutinen();
            malli.setName("Kumpulassa opiskeltiin ahkerasti");
            malli.setIngressi("Webpalvelinohjelmoinnin kurssiprojekti teetti rutkasti töitä opiskelijoille. Opiskelijat ahersivat projektin kimpussa yötä päivää ;)");
            malli.setSisalto("Webpalvelinohjelmoinnin kurssiprojekti teetti rutkasti töitä opiskelijoille. Opiskelijat ahersivat projektin kimpussa yötä päivää, jotta palautukseen saataisiin edes jonkinlainen projekti.Projektin laatimiseen oli harmittavan vähän aikaa ja ohjausta");
            //eka.setJulkaisuaika(time);
            malli.setKirjoittajat("Martta Meikäläinen");
            malli.setKategoria("Paikallisuutiset");
            uutinenRepository.save(malli);
        }

        model.addAttribute("uutiset", uutinenRepository.findAll());   
        // model.addAttribute("uutiset", uutinenService.list());
        return "index";
    }
    

    @DeleteMapping("/uutinen/{uutinenId}")
    public String remove(@PathVariable(value = "uutinenId") Long uutinenId) {
        uutinenRepository.deleteById(uutinenId);
        return "redirect:/";
    }
 

    @PostMapping("/")
    public String createUutinen(@RequestParam String name, String ingressi, String sisalto, String kirjoittajat, String kategoria) {// LocalDateTime time,
        // uutinenService.add(name, ingressi, sisalto, time, kirjoittajat, kategoria); 
        // julkaisuaika = LocalDateTime.now();
        
        Uutinen eka = new Uutinen();
        eka.setName(name);
        eka.setIngressi(ingressi);
        eka.setSisalto(sisalto);
        //eka.setJulkaisuaika(time);
        eka.setKirjoittajat(kirjoittajat);
        eka.setKategoria(kategoria);
        uutinenRepository.save(eka);

        return "redirect:/";                   //"redirect:/";samalle sivulle
    }
}


//       @GetMapping("/uutinen/{uutinenId}")
//    public String view(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
//        model.addAttribute("uutiset", uutinenRepository.findById(uutinenId).get().getName());;
//        return "uutinen";
//    }
//    
//    @PostMapping("/")
//    public String create(@RequestParam String name){
//        Uutinen eka = new Uutinen();
//        eka.setName(name);
//        eka.getName();
//        eka.setIngressi(ingressi);
//        eka.getIngressi();
//        uutinenRepository.save(eka);
//        return "redirect:/";
//    }
//    @PostMapping("/actors/{actorId}/movies")
//    public String addActorToMovie(@PathVariable(value = "actorId") Long actorId,
//            @RequestParam(value = "movieId") Long movieId) {
//        uutinenRepository.addActorToMovie(actorId, movieId);
//        return "redirect:/actors";
//    }
//        
//    @GetMapping("/uutinen")
//    public String listaauutinen(Model model) {
//        model.addAttribute("uutiset", uutinenRepository.findAll());
////        model.addAttribute("items", itemRepository.findAll());
//        return "uutinen";
//    }
//    @PostMapping("/uutinen")
//    public String createuutinen(@RequestParam String head, String name) {
//        Uutinen ekauutinen = new Uutinen(head);
//        uutinenRepository.save(ekauutinen);
//        
////         Item i = new Item(name);
////        itemRepository.save(i);
//        
//        return "redirect:/uutinen";
