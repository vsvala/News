package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Uutinen;
import wad.domain.Uutinen;
import wad.repository.UutinenRepository;

@Controller
public class uutinenController {

    @Autowired
      private UutinenRepository uutinenRepository;
   

   
//    @GetMapping("/uutinen")
//    public String list(Model model) {
//        model.addAttribute("items", itemRepository.findAll());
//        return "/uutinen";
//    }

//    @PostMapping("/uutinen")
//    public String create(@RequestParam String name) {
//        Item i = new Item(name);
//        itemRepository.save(i);
//        return "redirect:/uutinen";
//    } 
    
//    @GetMapping("/uutinen")
//    public String listaauutinen(Model model) {
//        model.addAttribute("uutiset", uutinenRepository.findAll());
////        model.addAttribute("items", itemRepository.findAll());
//        return "uutinen";
//    }
//
//    @PostMapping("/uutinen")
//    public String createuutinen(@RequestParam String head, String name) {
//        Uutinen ekauutinen = new Uutinen(head);
//        uutinenRepository.save(ekauutinen);
//        
////         Item i = new Item(name);
////        itemRepository.save(i);
//        
//        return "redirect:/uutinen";
//    }
}
