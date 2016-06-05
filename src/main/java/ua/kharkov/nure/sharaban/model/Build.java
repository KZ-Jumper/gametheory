package ua.kharkov.nure.sharaban.model;

import javax.persistence.*;

@Entity
@Table(name = "build")
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alternative_id", nullable = false)
    private Alternative alternative;

    @ManyToOne
    @JoinColumn(name = "criterion_id", nullable = false)
    private Criterion criterion;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
