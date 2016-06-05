package ua.kharkov.nure.sharaban.model;

import javax.persistence.*;

@Entity
@Table(name = "criterion")
public class Criterion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "criterionRange", columnDefinition = "int default 0")
    private int range;

    @Column(columnDefinition = "int default 0")
    private int weight;

    @Column
    private String type;

    @Column
    private String optimalType;

    @Column
    private String unit;

    @Column
    private String scaleType;

    @Column(name = "max_value", columnDefinition = "int default 0")
    private int minValue;

    @Column(name = "min_value", columnDefinition = "int default 0")
    private int maxValue;

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

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
