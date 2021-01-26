package kz.nursultan.model;

import kz.nursultan.enums.DisciplineType;

public class DisciplinePoint {
    private DisciplineType disciplineType;
    private double point;

    public DisciplinePoint(DisciplineType disciplineType, double point) {
        this.disciplineType = disciplineType;
        this.point = point;
    }

    public DisciplineType getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(DisciplineType disciplineType) {
        this.disciplineType = disciplineType;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
