package sk.fsa.project.fsaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tim")
public class Tim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @JsonIgnore
//    @OneToOne(mappedBy = "tim", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "tim")
    public Set<Prihlaska> prihlaska;

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "heslo")
    private String heslo;

    public Tim() {
    }

    public Tim(long id, Set<Prihlaska> prihlaska, String nazov, String heslo) {
        this.id = id;
        this.prihlaska = prihlaska;
        this.nazov = nazov;
        this.heslo = heslo;
    }

    public Set<Prihlaska> getPrihlaska() {
        return prihlaska;
    }

    public void setPrihlaska(Set<Prihlaska> prihlaska) {
        this.prihlaska = prihlaska;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }


}
