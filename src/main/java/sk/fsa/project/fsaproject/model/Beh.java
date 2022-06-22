package sk.fsa.project.fsaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "beh")
public class Beh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "beh")
    public Set<Stanovisko> stanovisko;

    @JsonIgnore
    @OneToMany(mappedBy = "beh")
    public Set<Prihlaska> prihlaska;

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "kapacita")
    private int kapacita;

    @Column(name = "prihlaseni")
    private int prihlaseni;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "datum")
    private Date datum;

    @Column(name = "zakladna_cena_behu")
    private int zakladnaCenaBehu;

    @Column(name = "cena_batozina")
    private int cenaBatozina;

    public Beh() {
    }

    public Beh(long id, Set<Stanovisko> stanovisko, Set<Prihlaska> prihlaska, String nazov, int kapacita, int prihlaseni, Date datum, int zakladnaCenaBehu, int cenaBatozina) {
        this.id = id;
        this.stanovisko = stanovisko;
        this.prihlaska = prihlaska;
        this.nazov = nazov;
        this.kapacita = kapacita;
        this.prihlaseni = prihlaseni;
        this.datum = datum;
        this.zakladnaCenaBehu = zakladnaCenaBehu;
        this.cenaBatozina = cenaBatozina;
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

    public int getKapacita() {
        return kapacita;
    }

    public void setKapacita(int kapacita) {
        this.kapacita = kapacita;
    }

    public int getPrihlaseni() {
        return prihlaseni;
    }

    public void setPrihlaseni(int prihlaseni) {
        this.prihlaseni = prihlaseni;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getZakladnaCenaBehu() {
        return zakladnaCenaBehu;
    }

    public void setZakladnaCenaBehu(int zakladnaCenaBehu) {
        this.zakladnaCenaBehu = zakladnaCenaBehu;
    }

    public int getCenaBatozina() {
        return cenaBatozina;
    }

    public void setCenaBatozina(int cenaBatozina) {
        this.cenaBatozina = cenaBatozina;
    }

    public Set<Stanovisko> getStanovisko() {
        return stanovisko;
    }

    public void setStanovisko(Set<Stanovisko> stanovisko) {
        this.stanovisko = stanovisko;
    }

    public Set<Prihlaska> getPrihlaska() {
        return prihlaska;
    }

    public void setPrihlaska(Set<Prihlaska> prihlaska) {
        this.prihlaska = prihlaska;
    }
}
