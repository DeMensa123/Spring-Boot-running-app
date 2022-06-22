package sk.fsa.project.fsaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stanica")
public class Stanica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "stanica")
    public Set<Stanovisko> stanovisko;

    public Set<Stanovisko> getStanovisko() {
        return stanovisko;
    }

    public void setStanovisko(Set<Stanovisko> stanovisko) {
        this.stanovisko = stanovisko;
    }

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "zem_dlzka")
    private int zemDlzka;

    @Column(name = "zem_sirka")
    private int zemSirka;

    @Column(name = "vyska")
    private int vyska;

    public Stanica() {
    }

    public Stanica(long id, String nazov, int zemDlzka, int zemSirka, int vyska) {
        this.id = id;
        this.nazov = nazov;
        this.zemDlzka = zemDlzka;
        this.zemSirka = zemSirka;
        this.vyska = vyska;
    }

    public int getZemDlzka() {
        return zemDlzka;
    }

    public void setZemDlzka(int zemDlzka) {
        this.zemDlzka = zemDlzka;
    }

    public int getZemSirka() {
        return zemSirka;
    }

    public void setZemSirka(int zemSirka) {
        this.zemSirka = zemSirka;
    }

    public int getVyska() {
        return vyska;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
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
