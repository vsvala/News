package wad.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Kategoriat extends AbstractPersistable<Long> {

    private String identifier;
    private String name;
    @OneToMany(mappedBy = "kategoria", fetch = FetchType.EAGER)
    private List<Uutinen> uutiset;
//     private String ulkomaanuutiset;  
//     private String politiikka;
//     private String urheilu;
//     private String kulttuuri;
//     private String talous; 

//     public Kategoriat() {  //pitääkö alustaa valmiiksi  atribuuteina vai saako vaan aina eri nimen
//       this.name="kategorian nimi";
//    }
// 
         public Kategoriat(String name) {
         this.name=name;
    }
 
    
//        public String getIdentifier() {
//        return identifier;
//    }
// 
//    public void setIdentifier(String identifier) {
//        this.identifier = identifier;
//    }
    
    public void addUutinen(Uutinen uutinen) {
        if (this.uutiset == null) {
            this.uutiset = new ArrayList<Uutinen>();
        }
 
        this.uutiset.add(uutinen);
    }
 
    public List<Uutinen> getUutislista() {
        return uutiset;
    }
 
    public void setUutislista(List<Uutinen> uutiset) {
        this.uutiset = uutiset;
    }
 
}
//    
//    public void addAircraft(Aircraft aircraft) {
//        if (this.aircrafts == null) {
//            this.aircrafts = new ArrayList<Aircraft>();
//        }
// 
//        this.aircrafts.add(aircraft);
//    }
// 
//    public List<Aircraft> getAircrafts() {
//        return aircrafts;
//    }
// 
//    public void setAircrafts(List<Aircraft> aircrafts) {
//        this.aircrafts = aircrafts;
    
    
  
    
//    public Kategoria(String name, String ingres, String kuva) {
//        this.name= name;
//        this.ingres=ingres;
//        this.kuva=kuva; 
//    }
    
       
//    public Kategoria(String name, LocalDateTime aika) {
//        this.name= name;
//        this.aika=aika;
//    }
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
    

