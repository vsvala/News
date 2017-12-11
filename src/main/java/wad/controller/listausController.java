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
        return "listaus";
    }

}
