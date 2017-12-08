package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Uutinen;
import wad.repository.UutinenRepository;

@Controller
public class listausController {

    @Autowired
    private UutinenRepository uutinenRepository;

        @GetMapping("/listaus")
    public String list(Model model) {
        model.addAttribute("uutiset", uutinenRepository.findAll());
        //model.addAttribute("actors", actorService.list());
        return "uutinen";
    }

    @GetMapping("/listaus/{uutinenId}")
    public String view(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
                model.addAttribute("news", uutinenRepository.getOne(uutinenId));
                model.addAttribute("uutiset", uutinenRepository.findAll());
       // model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
//     model.addAttribute("actor", actorService.findById(actorId));
        //    model.addAttribute("movies", movieService.listMoviesWithout(actorId))
        return "listaus";
//return "actor"
    }
        @PostMapping("/listaus/{uutinenId}")
    public String createUutinen(@RequestParam String name, String ingressi, String sisalto, String kirjoittajat, String kategoria, @PathVariable(value = "actorId") Long uutinenId) {  // Integer julkaisuaika,, 
        //uutinenService.add(name, ingressi,sisalto,julkaisuaika,kirjoittajat,kategoria);
        Uutinen eka = new Uutinen();
        eka.setName(name);
        eka.setIngressi(ingressi);
        eka.setSisalto(sisalto);
        eka.setIdentifier(uutinenId);
        //eka.setJulkaisuaika(julkaisuaika);
        eka.setKirjoittajat(kirjoittajat);
        eka.setKategoria(kategoria);
        uutinenRepository.save(eka);

        return "redirect:/listaus/*";
    }

}
   
    
//
//    @PostMapping("/")
//    public String create(@RequestParam String name) {
//        Item i = new Item(name);
//        itemRepository.save(i);
//        return "redirect:/";
//    }
//}


//    @GetMapping("/uutinen/{uutinenId}")
//    
//    public String listaaUutinen(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {// (value="uutinenId") {
//      //  model.addAttribute("uutiset", uutinenService.list());
//      //luo uus uutinen tms
//      // Uutinen uutinen = new Uutinen();
//       //uutinen.setIdentifier(uutinenId);
//       //uutinen.setIdentifier(uutinenId);
//       //uutinenRepository.save(uutinen);
//       // System.out.println("testitulostus"+uutinen.getId().toString());
//     // model.addAttribute("uutiset", uutinen.getId().toString());
//     //model.addAttribute("uutiset", uutinenRepository.findById(uutinen.getId()).toString());
//        // model.addAttribute("uutiset",uutinen.getId());
//        model.addAttribute("uutiset", uutinenRepository.findAll());
//       // model.addAttribute("uutiset", uutinenRepository.findById(uutinenId).get().getName());
//         //  model.addAttribute("uutiset", uutinenRepository.findById(uutinenId).toString());
//       return "uutinen";
// 
//    }
//    
//       @GetMapping("/actors/{actorId}")
//    public String view(Model model, @PathVariable(value = "actorId") Long actorId) {
//        model.addAttribute("actor", actorService.findById(actorId));
//        model.addAttribute("movies", movieService.listMoviesWithout(actorId));
//        return "actor";
//    }
//    
//    public Actor findById(Long actorId) {
//        return actorRepository.getOne(actorId);
//    }
//    
//
//    @GetMapping("/uutinen/{uutinenId}")
//    public String yksiUutinen(Model model, @PathVariable String uutinenId) {// (value="uutinenId")
//       model.addAttribute("uutiset", uutinenRepository.toString());
////      // model.addAttribute("news", uutinenRepository.findById(uutinenId.longValue()).get().getName());
//    model.addAttribute("uutiset", uutinenRepository.findAll());
//////          model.addAttribute("news", uutinenRepository.findById(uutinenId).get().getSisalto());
//////            // model.addAttribute("news", uutinenRepository.findById(uutinenId).get().getJulkaisuaika());
//////                model.addAttribute("news", uutinenRepository.findById(uutinenId).get().getKirjoittajat());
//////                   model.addAttribute("news", uutinenRepository.findById(uutinenId).get().getKategoria());
////    
////       
////           //model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
////       //model.addAttribute("uutiset", uutinenRepository.getOne(uutinenId).getName());
//        return "uutinen";
//    }   
 
 