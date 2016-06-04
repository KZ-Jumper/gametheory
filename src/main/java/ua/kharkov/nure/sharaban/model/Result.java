package ua.kharkov.nure.sharaban.model;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lprId")
    private LPR lpr;

    @ManyToOne
    @JoinColumn(name = "alternativeId")
    private Alternative alternative;

    @Column(name = "resultRange")
    private int range;

    @Column
    private int weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LPR getLpr() {
        return lpr;
    }

    public void setLpr(LPR lpr) {
        this.lpr = lpr;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
