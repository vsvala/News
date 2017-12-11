package wad.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kategoriat;
import wad.domain.Uutinen;
import wad.repository.KategoriatRepository;
import wad.repository.UutinenRepository;
//import service.UutinenService;

@Controller
public class uutinenController {

    @Autowired
    private UutinenService uutinenService;
    @Autowired
    private KategoriatRepository kategoriatRepository;
    @Autowired
    private UutinenRepository uutinenRepository;

    @GetMapping("/uutinen")
    public String list(Model model) {
        model.addAttribute("uutiset", uutinenService.list());
        return "uutinen";
    }
    
    @GetMapping("/uutinen/{uutinenId}")
    public String view(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
        model.addAttribute("kategoriat", kategoriatRepository.findAll());
         //model.addAttribute("kate", kategoriatRepository.findById(uutinenId));
         //model.addAttribute("kate", uutinenRepository.getOne(uutinenId).getKategoria().getName());
        model.addAttribute("news", uutinenRepository.getOne(uutinenId));
        model.addAttribute("uutiset", uutinenRepository.findAll());
        
        //model.addAttribute("kategorian", kategoriatRepository.getOne(uutinenId).getName());  //  model.addAttribute("kategoriat", kategoriatRepository.findAll());
        // model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
//     model.addAttribute("actor", actorService.findById(actorId));
        //    model.addAttribute("movies", movieService.listMoviesWithout(actorId))
        return "uutinen";
    }
//    
//    public String viewKtegories(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
//         model.addAttribute("kateg", kategoriatRepository.findAll());
//         model.addAttribute("ka", kategoriatRepository.getOne(uutinenId).getName());
//        return "uutinen";
//    }
 
    
     @PostMapping("/uutinen/{uutinenId}")
    public String add(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori, Kategoriat kategoria) {
        uutinenService.add(name, ingres, sisalto, kuva, kirjoittajat, kategori, kategoria);
        return "redirect:/";
    }
 
//lisää ohjaa lisää uutisen  submit   uutinen sivustolle
    @PostMapping("/uutinen/{uutinenId}/kategoriat")
    public String addUutinenToKategoria(@PathVariable(value = "uutinenId") Long uutinenId,
        @RequestParam(value = "kategoriaId") Long kategoriaId, String kategori) {
        uutinenService.addUutinenToKategory(uutinenId, kategoriaId, kategori);
        return "redirect:/uutinen";
    }
}


//    @GetMapping("/uutinen")
//    public String list(Model model) {
//        model.addAttribute("uutiset", uutinenRepository.findAll());
//        //model.addAttribute("actors", actorService.list());
//        return "uutinen";
//    }
//    @PostMapping("/uutinen/{uutinenId}")
//    public String createUutinen(@RequestParam String name, String ingres, String kuva, String sisalto, String kirjoittajat, String kategori) {//@PathVariable(value = "actorId") Long uutinenId) {  // Integer julkaisuaika,, 
//        //uutinenService.add(name, ingressi,sisalto,julkaisuaika,kirjoittajat,kategoria);
//        Uutinen eka = new Uutinen();
//        eka.setName(name);
//        eka.setIngres(ingres);
//        eka.setSisalto(sisalto);
//        eka.setKuva(kuva);
//        //eka.setIdentifier(uutinenId);
//        eka.setAika(LocalDateTime.now());
//        eka.setKirjoittajat(kirjoittajat);
//        eka.setKategori(kategori);
//        uutinenRepository.save(eka);
//
//        return "redirect:/uutinen/*";
//    }
//tämä korvattu servisellä
//    @PostMapping("/uutinen/{uutinenId}")
//    public String createUutinen(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori, Kategoriat kategoria){
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
//        return "redirect:/uutinen/*";                   //  "redirect:/";  samalle sivulle
//    }
//  }   
//    

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

