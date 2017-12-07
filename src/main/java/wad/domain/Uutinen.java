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
    private Integer julkaisuaika;
   // private LocalDateTime messageDate;
    private String kirjoittajat;
    private String kategoria; 
       

   // public Uutinen() {
    //    this.messageDate = LocalDateTime.now();
   // }
////
//     public Uutinen findById(Long uutinenId) {
//        return uutinenRepository.getOne(uutinenId);
//    }
    

}
