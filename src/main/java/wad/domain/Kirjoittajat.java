package wad.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Kirjoittajat extends AbstractPersistable<Long> {

    @Column
    private String name;
    @ManyToMany(mappedBy = "kirjoittajat", fetch = FetchType.EAGER)
    private List<Uutinen> uutiset;

        public Kirjoittajat(String name) {
        this.name=name;
    }

//
//    public List<Uutinen> getUutinen() {
//        return uutiset;
//    }
//
//    public void setuutiset(List<Uutinen> uutiset) {
//        this.uutiset = uutiset;
//    }
}
