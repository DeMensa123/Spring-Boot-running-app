package sk.fsa.project.fsaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "stanovisko")
public class Stanovisko {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_stanica", nullable = false)
    public Stanica stanica;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_beh", nullable = false)
    public Beh beh;

    public Stanica getStanica() {
        return stanica;
    }

    public void setStanica(Stanica stanica) {
        this.stanica = stanica;
    }

    public Beh getBeh() {
        return beh;
    }

    public void setBeh(Beh beh) {
        this.beh = beh;
    }

    @Column(name = "poradie")
    private int poradie;

    @Column(name = "lekar")
    private boolean lekar;

    @Column(name = "obcerstvenie")
    private boolean obcerstvenie;

    @Column(name = "vzdialenost_predchadzajuceho_stanoviska")
    private int vzdialenostPredStanoviska;

    @Column(name = "prevysenie")
    private int prevysenie;

    public Stanovisko() {
    }

    public Stanovisko(long id, Stanica stanica, Beh beh, int poradie, boolean lekar, boolean obcerstvenie, int vzdialenostPredStanoviska, int prevysenie) {
        this.id = id;
        this.stanica = stanica;
        this.beh = beh;
        this.poradie = poradie;
        this.lekar = lekar;
        this.obcerstvenie = obcerstvenie;
        this.vzdialenostPredStanoviska = vzdialenostPredStanoviska;
        this.prevysenie = prevysenie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPoradie() {
        return poradie;
    }

    public void setPoradie(int poradie) {
        this.poradie = poradie;
    }

    public boolean isLekar() {
        return lekar;
    }

    public void setLekar(boolean lekar) {
        this.lekar = lekar;
    }

    public boolean isObcerstvenie() {
        return obcerstvenie;
    }

    public void setObcerstvenie(boolean obcerstvenie) {
        this.obcerstvenie = obcerstvenie;
    }

    public int getVzdialenostPredStanoviska() {
        return vzdialenostPredStanoviska;
    }

    public void setVzdialenostPredStanoviska(int vzdialenostPredStanoviska) {
        this.vzdialenostPredStanoviska = vzdialenostPredStanoviska;
    }

    public int getPrevysenie() {
        return prevysenie;
    }

    public void setPrevysenie(int prevysenie) {
        this.prevysenie = prevysenie;
    }

}
