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
    private KategoriatRepository kategoriatRepository;

    @GetMapping("/kategoriat")
    public String listaa(Model model) {
        Kategoriat kategoria = new Kategoriat();
        model.addAttribute("kateg", kategoria.getUutiset());
        model.addAttribute("kategoriat", kategoria.getName());
        model.addAttribute("uutiset", uutinenRepository.findAll());
        model.addAttribute("kategoriat", kategoriatRepository.findAll());
        return "kategoriat";
    }

    @GetMapping("/kategoriat/{kategoriatId}")
    public String list(Model model) {
        Kategoriat kategoria = new Kategoriat();
        model.addAttribute("kateg", kategoria.getUutiset());
        model.addAttribute("kategoriat", kategoria.getName());
        model.addAttribute("uutiset", uutinenRepository.findAll());
        model.addAttribute("kategoriat", kategoriatRepository.findAll());

        return "kategoriat";

    }

    @PostMapping("/kategoriat/{kategoriatId}")
    public String add(@RequestParam String kategori) {
        Kategoriat kategoria = new Kategoriat();
        kategoria.setName(kategori);
        kategoriatRepository.save(kategoria);

        return "redirect:/kategoriat";
    }

}
