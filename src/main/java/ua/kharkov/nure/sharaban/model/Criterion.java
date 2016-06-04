package ua.kharkov.nure.sharaban.model;

import javax.persistence.*;

@Entity
@Table(name = "criterion")
public class Criterion {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "criterionRange")
    private int range;

    @Column
    private int weight;

    @Column
    private String type;

    @Column
    private String optimalType;

    @Column
    private String unit;

    @Column
    private String scaleType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOptimalType() {
        return optimalType;
    }

    public void setOptimalType(String optimalType) {
        this.optimalType = optimalType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getScaleType() {
        return scaleType;
    }

    public void setScaleType(String scaleType) {
        this.scaleType = scaleType;
    }
}
