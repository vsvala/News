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
        model.addAttribute("news", uutinenRepository.getOne(uutinenId));
        model.addAttribute("uutiset", uutinenRepository.findAll());

        return "uutinen";
    }
 
    
     @PostMapping("/uutinen/{uutinenId}")
    public String add(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittaja, String kategori, Kategoriat kategoria) {
        uutinenService.add(name, ingres, sisalto, kuva, kirjoittaja, kategori, kategoria);
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
