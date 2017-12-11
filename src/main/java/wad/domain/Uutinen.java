package wad.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;
import org.springframework.data.jpa.domain.AbstractPersistable;

//@RequiredArgsConstructor 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Uutinen extends AbstractPersistable<Long> {

  
    private String name;
    @ManyToOne
    private Kategoriat kategoria;
   //@OneToMany(fetch=FetchType.EAGER)
   // private List<Kategoriat>kategorialista;//= new ArrayList<>()
    private String ingres;   
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Kirjoittajat> kirjoittajat;
    private String sisalto;
    private String kuva;
    private LocalDateTime aika;
    //private Kirjoittaja kirjoittaja;
    private String kirjoittaja;
    //private Kategoriat kategoria;
    private String kategori; 
    private Long identifier;
    
    
    
    public Uutinen(String name, String ingres, String kuva) {
        this.name= name;
        this.ingres=ingres;
        this.kuva=kuva; 
    }
    
       
    public Uutinen(String name, LocalDateTime aika) {
        this.name= name;
        this.aika=aika;
    }
    
//    public void seKategoriat(List<Kategoriat> kategorialista) {
//    this.kategorialista = kategorialista;
//     }
//    
//    
//    public List<Kategoriat> getKategoriat() {
//        if (this.kategorialista == null) {
//            this.kategorialista = new ArrayList<>();
//        }
//        return this.kategorialista;
    }
    
    
    
    
    
    
    
    
    
    
    
    
   // private List<Uutinen>uutislista;   many to
//  public Uutinen() {
//    
//      } 
// public Uutinen( String name,  String sisalto,  LocalDateTime julkaisuaika, String kirjoittajat, String kategoria) {
//     this.julkaisuaika = LocalDateTime.now();
//     this.
//     
//      }    
// public Uutinen(LocalDateTime julkaisuaika) {
//        this.julkaisuaika = LocalDateTime.now();
//      } 
//    public void setTime() {
//        this.julkaisuaika = LocalDateTime.now();
//        
//    }
     
  
    
   // public Uutinen() {
    //    this.messageDate = LocalDateTime.now();
   // }
////
//     public Uutinen findById(Long uutinenId) {
//        return uutinenRepository.getOne(uutinenId);
//    }
    

