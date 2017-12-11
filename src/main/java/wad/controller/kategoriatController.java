package wad.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kategoriat;
import wad.domain.Uutinen;
import wad.repository.KategoriatRepository;
import wad.repository.UutinenRepository;

@Controller
public class kategoriatController {

//    @Autowired
//    private UutinenService uutinenService;
    @Autowired
    private UutinenRepository uutinenRepository;
    @Autowired
    private KategoriatRepository kategoriaRepository;

//       @GetMapping("/kategoriat")
//    public String listaa(Model model) {
//     //   model.addAttribute("uutiset", uutinenRepository.findAll());
//        model.addAttribute("kategoriat", uutinenRepository.findAll());
//        //model.addAttribute("kategoriat", kategoriaRepository.findAll());
////        model.addAttribute("uutiset", kategoriaRepository.findAll());
//        // model.addAttribute("kate", kategoriaRepository.findAll());
//        //model.addAttribute("actors", actorService.list());
//        return "kategoriat";
//    }
//    
    @GetMapping("/kategoriat/{kategoriatId}")
    public String list(Model model) {
     //   model.addAttribute("uutiset", uutinenRepository.findAll());
//        model.addAttribute("kategoriat", uutinenRepository.findAll());
        model.addAttribute("kategoriat", kategoriaRepository.findAll());
//        model.addAttribute("uutiset", kategoriaRepository.findAll());
        // model.addAttribute("kate", kategoriaRepository.findAll());
        //model.addAttribute("actors", actorService.list());
        return "kategoriat";
    }

    @PostMapping("/kategoriat/{kategoriatId}")
    public String add(@RequestParam String kategori) {
        Kategoriat kategoria = new Kategoriat();
        kategoria.setName(kategori);

        kategoria.setName("testi");
        kategoriaRepository.save(kategoria);
        return "redirect:/kategoriat";
    }
    
 }
//    public String add(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori, Kategoriat kategoria) {
//        uutinenService.add(name, ingres, sisalto, kuva, kirjoittajat, kategori, kategoria);
//        return "redirect:/kategoriat";
//    }
//    @GetMapping("/kategoriat/{kategoriaId}")
//    public String view(Model model, @PathVariable(value = "kategoriaId") Long actorId) {
//        model.addAttribute("kategoria",// actorService.findById(actorId));
//      //  model.addAttribute("uutiset, //movieService.listMoviesWithout(actorId));
//        return "kategoria";
//    }
//    @PostMapping("/uutinen/{kategoriaId}/kategoriat")//("/kategoriat/{kategoriaId}/uutiset")
//    public String addActorToMovie(@PathVariable(value = "kategoriarId") Long kategoriaId,
//            @RequestParam(value = "uutinen") Long uutinenId) {
//            Kategoriat kategoria = kategoriaRepository.getOne(kategoriaId);
//            Uutinen uutinen = uutinenRepository.getOne(uutinenId);
//            kategoria.getUutiset().add(uutinen);
//            // uutinen.getKategoria().;
//       // actor.getMovies().add(movie);
//       // movie.getActors().add(actor);    
//        //actorService.addActorToMovie(actorId, movieId);
//        return "redirect:/kategoriat";
//    }
//   //____________________________________________________  tämä tuo sisällöön http://localhost:8080/uutinen/1/kategoriat   sivulle

//    @GetMapping("uutinen/{uutinenId}/kategoriat")
//    public String view(Model model, @PathVariable(value = "uutinenId") Long uutinenId) {
//        // model.addAttribute("news", uutinenRepository.getOne(uutinenId));
//        model.addAttribute("uutiset", uutinenRepository.findAll());
//        model.addAttribute("uu", uutinenRepository.findAll());
//        model.addAttribute("kategoriat", kategoriaRepository.findAll());
//        model.addAttribute("kategoria", kategoriaRepository.findAll());
//        // model.addAttribute("uutiset", uutinenRepository.findById(uutinenId));
////     model.addAttribute("actor", actorService.findById(actorId));
//        //    model.addAttribute("movies", movieService.listMoviesWithout(actorId))
//        return "kategoriat";
//    }
//
//    @PostMapping("/uutinen/{kategoriaId}/kategoriat")
//    public String createUutinen(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittajat, String kategori,
//            @PathVariable(value = "kategoriarId") Long kategoriaId,
//            @RequestParam(value = "uutinen") Long uutinenId) {//(@PathVariable(value = "uutinenId") Long uutinenId) {  // Integer julkaisuaika,, 
//        Kategoriat kategoria = kategoriaRepository.getOne(kategoriaId);
//        Uutinen uutinen = uutinenRepository.getOne(uutinenId);
//        kategoria.getUutiset().add(uutinen);
//        kategoriaRepository.save(kategoria);
//        uutinenRepository.save(uutinen);
//
//        return "redirect:/kategoriat";
//    }
//    
////:__________________--

//    @Autowired
//    private ActorService actorService;
//    @Autowired
//    private MovieService movieService;
// 
//
//    @PostMapping("/")
//    public String create(@RequestParam String name) {
//        Item i = new Item(name);
//        itemRepository.save(i);
//        return "redirect:/";
//    }
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

