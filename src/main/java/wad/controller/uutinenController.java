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
//import service.UutinenService;

@Controller
public class uutinenController {

//   @Autowired
//    private  UutinenService uutinenService;
//
     @Autowired
    private UutinenRepository uutinenRepository; 
     
    @GetMapping("/uutinen")
    
    public String listaaUutinen(Model model) {
      //  model.addAttribute("uutiset", uutinenService.list());
        model.addAttribute("uutiset", uutinenRepository.findAll());
       return "uutinen";
 
    }

    @GetMapping("/uutinen/{uutinenId}")
    public String yksiUutinen(Model model, @PathVariable(value="uutinenId") Long uutinenId) {// 
       model.addAttribute("uutinen", uutinenRepository.findById(uutinenId));
           //model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
       //model.addAttribute("uutiset", uutinenRepository.getOne(uutinenId).getName());
        return "uutinen";
    }

//    @PostMapping("/uutinen/{uutinenId}")
//    public String createUutinen(@RequestParam String name,Integer julkaisuaika, String kirjoittajat, String kategoria) {  // String ingressi, String sisalto
//        //uutinenService.add(name, ingressi,sisalto,julkaisuaika,kirjoittajat,kategoria);
//        Uutinen eka = new Uutinen();
//        eka.setName(name);
//        //eka.setIngressi(ingressi);
//       // eka.setSisalto(sisalto);
//        eka.setJulkaisuaika(julkaisuaika);
//        eka.setKirjoittajat(kirjoittajat);
//        eka.setKategoria(kategoria);
//        uutinenRepository.save(eka);
//
//        return "redirect:/uutinen";
//    }

}
