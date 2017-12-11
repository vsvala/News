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