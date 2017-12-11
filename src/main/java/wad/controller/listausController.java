package wad.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

@Controller
public class listausController {
    private List<Uutinen> uutislista;

    public listausController() {
        this.uutislista = new ArrayList<>();
//       this.uutislista.add(new Uutinen("uutinen1", "ingress", "kuva" ,"sisältö"," kirjoittaja"));
    }
    @Autowired
    private UutinenService uutinenService;
    @Autowired
    private KategoriatRepository kategoriatRepository;
    @Autowired
    private UutinenRepository uutinenRepository;

    @GetMapping("/listaus")
    public String list(Model model) {
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "aika");
        model.addAttribute("uutiset", uutinenRepository.findAll(pageable));
        
        return "listaus";
    }

    @GetMapping("/listaus/{uutinenId}")
    public String view(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
        model.addAttribute("lista", uutislista);
        model.addAttribute("kategoriat", kategoriatRepository.findAll());
        model.addAttribute("news", uutinenRepository.findAll());
//        model.addAttribute("news", uutinenRepository.getOne(uutinenId));
//        model.addAttribute("uutiset", uutinenRepository.findAll());
        // model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
//     model.addAttribute("actor", actorService.findById(actorId));
        //    model.addAttribute("movies", movieService.listMoviesWithout(actorId))
        return "listaus";
    }
//
//    @PostMapping("/listaus/{uutinenId}")
//    public String createUutinen(@RequestParam String name, String ingres, String kuva, String sisalto, String kirjoittajat, String kategori, Kategoriat kategoria) {//@PathVariable(value = "actorId") Long uutinenId) {  // Integer julkaisuaika,, 
//        //uutinenService.add(name, ingressi,sisalto,julkaisuaika,kirjoittajat,kategoria);
//
//        Uutinen eka = new Uutinen();
//        eka.setName(name);
//        eka.setIngres(ingres);
//        eka.setSisalto(sisalto);
//        eka.setKuva(kuva);
//        //eka.setIdentifier(uutinenId);
//        eka.setAika(LocalDateTime.now());
//        eka.setKirjoittajat(kirjoittajat);
//        //eka.setKategoria(new Kategoriat(kategori));
//       // eka.setKategori(kategori);
//        this.uutislista.add(eka);
//
//        kategoriatRepository.save(kategoria);
//        uutinenRepository.save(eka);
//
//        //  return "redirect:/listaus/*";
//        return "redirect:/listaus";                   //  "redirect:/";  samalle sivulle
//    }
}
//     
//     @PostMapping("/listaus/{uutinenId}")
//    public String add(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori, Kategoriat kategoria) {
//        uutinenService.add(name, ingres, sisalto, kuva, kirjoittajat, kategori, kategoria);
//        return "redirect:/";
//    }
// 
////lisää ohjaa lisää uutisen  submit   uutinen sivustolle
//    @PostMapping("/uutinen/{uutinenId}/kategoriat")
//    public String addUutinenToKategoria(@PathVariable(value = "uutinenId") Long uutinenId,
//        @RequestParam(value = "kategoriaId") Long kategoriaId, String kategori) {
//        uutinenService.addUutinenToKategory(uutinenId, kategoriaId, kategori);
//        return "redirect:/uutinen";
//     
//    

//    @GetMapping("/listaus/{uutinenId}")
//    public String view(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
//      // model.addAttribute("news", uutinenRepository.getOne(uutinenId));
//        //model.addAttribute("news", uutinenRepository.getOne(uutinenId).getId().toString());
//          //  model.addAttribute("news", uutinenRepository.getOne(uutinenId));
//              //  model.addAttribute("uutiset", uutinenRepository.getOne(uutinenId).getAika());
//        model.addAttribute("uutiset", uutinenRepository.findAll());
//    
//       //model.addAttribute("uutiset", uutinenRepository.findById(uutinenId.).get().getName());
////     model.addAttribute("actor", actorService.findById(actorId));
//        //    model.addAttribute("movies", movieService.listMoviesWithout(actorId))
//        return "listaus";
//
//    }
//        @GetMapping("/uutinen/{uutinenId}")
//    public String viewByKategoria(Model model, @PathVariable(value = "uutinenId") Long uutinenId, @RequestParam String name, String time) {
//        model.addAttribute("news", uutinenRepository.getOne(uutinenId));
//        model.addAttribute("uutiset", uutinenRepository.findAll());
//        // model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
////     model.addAttribute("actor", actorService.findById(actorId));
//        //    model.addAttribute("movies", movieService.listMoviesWithout(actorId))
//        return "uutinen";
////return "actor"
//    }
//        if (!name.trim().isEmpty() && !type.trim().isEmpty()) {
//            this.items.add(new Item(name.trim(), type.trim()));
//        }
//    
//    
//        @PostMapping("/listaus")
//    public String createUutinen(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategoria, @PathVariable(value = "actorId") Long uutinenId) {  // Integer julkaisuaika,, 
//        //uutinenService.add(name, ingressi,sisalto,julkaisuaika,kirjoittajat,kategoria);
//        Uutinen eka = new Uutinen();
//        eka.setName(name);
//        eka.setIngres(ingres);
//        eka.setSisalto(sisalto);
//        eka.setKuva(kuva);
//        //eka.setIdentifier(uutinenId);
//        eka.setAika(LocalDateTime.now());
//        eka.setKirjoittajat(kirjoittajat);
//        eka.setKategoria(kategoria);
//        uutinenRepository.save(eka);
//
//        return "redirect:/listaus";
//    }
//       @PostMapping("/listaus/{uutinenId}")
//    public String createUutinen(@RequestParam String name, String ingres,  String kuva, @PathVariable(value = "actorId") Long uutinenId) {  // Integer julkaisuaika,, 
//        //uutinenService.add(name, ingressi,sisalto,julkaisuaika,kirjoittajat,kategoria);
//        Uutinen toka = new Uutinen();
//        toka.setName(name);
//        toka.setIngres(ingres);
//        toka.setKuva(kuva);
//        toka.setIdentifier(uutinenId);
//        toka.setAika(LocalDateTime.now());
//        uutinenRepository.save(toka);
//
//        return "redirect:/listaus/*";
//    }
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
