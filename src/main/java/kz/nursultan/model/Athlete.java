package kz.nursultan.model;

import java.util.List;
import java.util.Objects;

public class Athlete implements Comparable<Athlete> {
    private String name;
    private String place;
    private double totalPoint;
    private List<DisciplinePoint> disciplinePoints;

    public Athlete(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        this.totalPoint = totalPoint;
    }

    public List<DisciplinePoint> getDisciplinePoints() {
        return disciplinePoints;
    }

    public void setDisciplinePoints(List<DisciplinePoint> disciplinePoints) {
        this.disciplinePoints = disciplinePoints;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", totalPoint=" + totalPoint +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete that = (Athlete) o;
        return Double.compare(that.totalPoint, totalPoint) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPoint);
    }

    @Override
    public int compareTo(Athlete o) {
        return (int) (o.totalPoint - totalPoint);
    }
}
