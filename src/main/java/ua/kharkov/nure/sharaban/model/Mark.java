package ua.kharkov.nure.sharaban.model;

import javax.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "criterionId", nullable = false)
    private Criterion criterion;

    @Column
    private String name;

    @Column(name = "markRange")
    private int range;

    @Column
    private int markNumberEquivalent;

    @Column
    private int normalizedMark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMarkNumberEquivalent() {
        return markNumberEquivalent;
    }

    public void setMarkNumberEquivalent(int markNumberEquivalent) {
        this.markNumberEquivalent = markNumberEquivalent;
    }

    public int getNormalizedMark() {
        return normalizedMark;
    }

    public void setNormalizedMark(int normalizedMark) {
        this.normalizedMark = normalizedMark;
    }
}
