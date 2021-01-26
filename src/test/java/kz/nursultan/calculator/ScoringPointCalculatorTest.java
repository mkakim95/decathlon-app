package kz.nursultan.calculator;

import kz.nursultan.enums.DisciplineType;
import kz.nursultan.model.DisciplinePoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScoringPointCalculatorTest {
    private final ScoringPointCalculator calculator = new ScoringPointCalculator();

    @Test
    void getPoint() {
//        y = a * |x - b|^c
        Assertions.assertEquals(43.227, calculator.getPoint("1", DisciplineType.DISCUS_THROW));
        Assertions.assertEquals(4290.826, calculator.getPoint("1", DisciplineType.RUN_100_METER));
    }

    @Test
    void getTotalPoint() {
        List<DisciplinePoint> disciplinePoints = List.of(
                new DisciplinePoint(DisciplineType.DISCUS_THROW, 10),
                new DisciplinePoint(DisciplineType.HIGH_JUMP, 10));
        Assertions.assertEquals(20, calculator.getTotalPoint(disciplinePoints));
    }
}
