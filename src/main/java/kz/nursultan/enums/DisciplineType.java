package kz.nursultan.enums;

import java.util.Arrays;

public enum DisciplineType {
    RUN_100_METER(1, "Бег на 100 метров", 25.4348, 18, 1.81, MeasureUnitType.SEC),
    LONG_JUMP(2, "Прыжки в длину", 90.5674, 2.2, 1.4, MeasureUnitType.METRE),
    SHOT_PUT(3, "Толкание ядра", 51.39, 1.5, 1.05, MeasureUnitType.METRE),
    HIGH_JUMP(4, "Прыжки в высоту", 585.64, 0.75, 1.42, MeasureUnitType.METRE),
    RUN_400_METER(5, "Бег на 400 метров", 1.53775, 82, 1.81, MeasureUnitType.SEC),
    RUN_110_METER_WITH_BARRIER(6, "Бег на 110 метров с барьерами", 5.74354, 28.5, 1.92, MeasureUnitType.SEC),
    DISCUS_THROW(7, "Метание диска", 12.91, 4, 1.1, MeasureUnitType.METRE),
    POLE_VAULT(8, "Прыжки с шестом", 140.182, 1, 1.35, MeasureUnitType.METRE),
    JAVELIN_THROW(9, "Метание копья", 10.14, 7, 1.08, MeasureUnitType.METRE),
    RUN_1500_METER(10, "Бег на 1500 метров", 0.03768, 480, 1.85, MeasureUnitType.SEC);

    private final int id;
    private final String name;
    private final double aCoef;
    private final double bCoef;
    private final double cCoef;
    private final MeasureUnitType measureUnitType;

    DisciplineType(int id, String name, double a, double b, double c, MeasureUnitType measureUnitType) {
        this.id = id;
        this.name = name;
        this.aCoef = a;
        this.bCoef = b;
        this.cCoef = c;
        this.measureUnitType = measureUnitType;
    }

    public static DisciplineType getById(int id) {
        return Arrays.stream(values())
                .filter(disciplineType -> disciplineType.getId() == id)
                .findAny().orElseThrow(() -> new RuntimeException("discipline not found..."));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getaCoef() {
        return aCoef;
    }

    public double getbCoef() {
        return bCoef;
    }

    public double getcCoef() {
        return cCoef;
    }

    public MeasureUnitType getMeasureUnitType() {
        return measureUnitType;
    }
}
