package wad.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;


@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
public class Uutinen extends AbstractPersistable<Long> {

    
    private String name;
    private String ingressi;  
    private String sisalto;
    //private LocalDateTime time;
    private String kirjoittajat;
    private String kategoria; 
   // private Long identifier;
//  public Uutinen() {
//    
//      } 
// public Uutinen( String name,String ingressi, String sisalto,  LocalDateTime julkaisuaika, String kirjoittajat, String kategoria) {
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
    

}
