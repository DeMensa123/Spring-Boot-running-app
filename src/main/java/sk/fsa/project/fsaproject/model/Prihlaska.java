package sk.fsa.project.fsaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "prihlaska")
public class Prihlaska {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_beh", nullable = false)
    public Beh beh;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_tim", nullable = false)
    public Tim tim;

    @Column(name = "celkova_cena")
    private int celkovaCena;

    @Column(name = "pocet_clenov_timu")
    private int pocetClenovTimu;

    @Column(name = "batozina")
    private boolean batozina;


    public Prihlaska() {
    }

    public Prihlaska(long id, Beh beh, Tim tim, int celkovaCena, int pocetClenovTimu, boolean batozina) {
        this.id = id;
        this.beh = beh;
        this.tim = tim;
        this.celkovaCena = celkovaCena;
        this.pocetClenovTimu = pocetClenovTimu;
        this.batozina = batozina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Beh getBeh() {
        return beh;
    }

    public void setBeh(Beh beh) {
        this.beh = beh;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getCelkovaCena() {
        return celkovaCena;
    }

    public void setCelkovaCena(int celkovaCena) {
        this.celkovaCena = celkovaCena;
    }

    public int getPocetClenovTimu() {
        return pocetClenovTimu;
    }

    public void setPocetClenovTimu(int pocetClenovTimu) {
        this.pocetClenovTimu = pocetClenovTimu;
    }

    public boolean getBatozina() {
        return batozina;
    }

    public void setBatozina(boolean batozina) {
        this.batozina = batozina;
    }
}
