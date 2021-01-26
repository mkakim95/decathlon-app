package kz.nursultan.calculator;

import kz.nursultan.enums.DisciplineType;
import kz.nursultan.enums.MeasureUnitType;
import kz.nursultan.model.DisciplinePoint;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class ScoringPointCalculator {
    DecimalFormat decimalFormat = new DecimalFormat(
            "####.###", DecimalFormatSymbols.getInstance(new Locale("en", "UK")));

    /**
     * formula :  y = a * |x - b|^c
     *
     * @param x              athlete result by discipline
     * @param disciplineType discipline
     * @return score point
     */
    public double getPoint(String x, DisciplineType disciplineType) {
        x = x.trim();
        double result = 0;
        if (disciplineType.getMeasureUnitType() == MeasureUnitType.SEC) {
            String[] val = x.split("\\.");
            result = val.length == 3
                    ? Integer.parseInt(val[0]) * 60 + Double.parseDouble(val[1] + "." + val[2])
                    : Double.parseDouble(x);
        } else {
            result = Double.parseDouble(x);
        }

        return Double.parseDouble(decimalFormat.format(
                disciplineType.getaCoef() * Math.pow(Math.abs(result - disciplineType.getbCoef()), disciplineType.getcCoef())));
    }

    public double getTotalPoint(List<DisciplinePoint> points) {
        double totalPoint = points.stream()
                .mapToDouble(DisciplinePoint::getPoint)
                .sum();
        return Double.parseDouble(decimalFormat.format(totalPoint));
    }
}
