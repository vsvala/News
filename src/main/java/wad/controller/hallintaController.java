package wad.controller;

//import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Kategoriat;
//import wad.domain.Kirjoittaja;
import wad.domain.Uutinen;
import wad.repository.KategoriatRepository;
import wad.repository.UutinenRepository;

@Controller
public class hallintaController {

    @Autowired
    private UutinenService uutinenService;   
    @Autowired
    private KategoriatRepository kategoriatRepository;
    @Autowired
    private UutinenRepository uutinenRepository;
  
 //luodaan malliuutinen ja  listataan kaikki  olemassa olevat uutiset tietokannasta ja palautetaan index sivulle
    @GetMapping("/")
    public String list(Model model) {         
        if (uutinenRepository.findAll().isEmpty()) {//size==0  ==null?
            Uutinen malli = new Uutinen(); 
            Kategoriat m =new Kategoriat("teeeeeeeeeeeestikateg");
            //Kirjoittaja haamukirjoittaja = new Kirjoittaja("Maija Meikäläinen");        
            //m.setUutiset(malli);  
            //malli.setKategoria(new Kategoriat("teeeeeeeeeeeeeestaaaaaaaaaaaaaaaktegooooooriaa"));
            m.setName("testigategoria");
            malli.setName("Kumpulassa opiskeltiin ahkerasti");
            malli.setIngres("Webpalvelinohjelmoinnin kurssiprojekti teetti rutkasti töitä opiskelijoille. Opiskelijat ahersivat projektin kimpussa yötä päivää ;)");
            malli.setSisalto("Webpalvelinohjelmoinnin kurssiprojekti teetti rutkasti töitä opiskelijoille. Opiskelijat ahersivat projektin kimpussa yötä päivää, jotta palautukseen saataisiin edes jonkinlainen projekti.Projektin laatimiseen oli harmittavan vähän aikaa ja ohjausta");
            malli.setKuva("tähän pitäis saada vielä kuva");
            malli.setKategori("PAIKALLISUUTISET");
            malli.setAika(LocalDateTime.now());
            malli.setKirjoittaja("Maija Meikäläinen");
            //malli.setKirjoittaja(haamukirjoittaja);
           // malli.setKirjoittajat(kirjoittajat);listalle lisääs...
            kategoriatRepository.save(m);   
            uutinenRepository.save(malli);
        }
   
        model.addAttribute("uutiset", uutinenRepository.findAll());  
        model.addAttribute("kategoriat", kategoriatRepository.findAll());
        return "index";
    }
    
    //poistetaan id:n mukainen uutinen tietokannasta ja uudelleen ohjataan indeksisivulle
    @DeleteMapping("/uutinen/{uutinenId}")
    public String remove(@PathVariable(value = "uutinenId") Long uutinenId) {
        kategoriatRepository.deleteById(uutinenId);
        return "redirect:/";
    }

    //luodaan uutinen ja lähetetään se tietokantaan
    @PostMapping("/")
    public String createUutinen(@RequestParam String name, String ingres, String sisalto, String kuva, String kirjoittaja, String kategori, Kategoriat kategoria){
        
        Uutinen eka = new Uutinen();
        //Kirjoittaja haamu = new kirjoittaja(kirjoittaja);  
        //eka.setKirjoittajat(haamu);
        eka.setName(name);
        eka.setIngres(ingres);
        eka.setSisalto(sisalto);
        eka.setKirjoittaja(kirjoittaja);
        eka.setKuva(kuva);
        eka.setAika(LocalDateTime.now());
        eka.setKategoria(kategoria);
        //eka.setKategoria(new Kategoriat(kategori)); 
       // eka.setKategoria(new Kategoriat(kategori));
        kategoriatRepository.save(kategoria);
        uutinenRepository.save(eka);
   
        return "redirect:/";                   //  "redirect:/";  samalle sivulle
    }
  }  