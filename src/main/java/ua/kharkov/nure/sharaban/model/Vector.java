package ua.kharkov.nure.sharaban.model;

import javax.persistence.*;

@Entity
@Table(name = "vector")
public class Vector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alternativeId", nullable = false)
    private Alternative alternative;

    @ManyToOne
    @JoinColumn(name = "markId", nullable = false)
    private Mark mark;

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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
