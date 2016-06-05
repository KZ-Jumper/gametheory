package ua.kharkov.nure.sharaban.model;

public class CriteriaMarkDTO {

    private long criteriaId;

    private String criteriaName;

    private int mark;

    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
