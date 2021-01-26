package kz.nursultan.input;

import kz.nursultan.calculator.ScoringPointCalculator;
import kz.nursultan.enums.DisciplineType;
import kz.nursultan.model.Athlete;
import kz.nursultan.model.DisciplinePoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CsvInput {
    private final ScoringPointCalculator calculator;
    private final InputStream is;

    public CsvInput() {
        var classloader = Thread.currentThread().getContextClassLoader();
        this.is = classloader.getResourceAsStream("results.csv");
        this.calculator = new ScoringPointCalculator();
    }

    public List<Athlete> getAthletes() {
        var athletes = new ArrayList<Athlete>();
        try {
            var csvReader = new BufferedReader(new InputStreamReader(is));
            String row;
            while ((row = csvReader.readLine()) != null && row.length() > 0) {
                var data = List.of(row.split(";"));
                var disciplinePoints = new ArrayList<DisciplinePoint>();
                for (int i = 1; i < data.size(); i++) {
                    DisciplineType disciplineType = DisciplineType.getById(i);
                    double point = calculator.getPoint(data.get(i), disciplineType);
                    disciplinePoints.add(new DisciplinePoint(DisciplineType.getById(i), point));
                }

                Athlete athlete = new Athlete(data.get(0));
                athlete.setTotalPoint(calculator.getTotalPoint(disciplinePoints));
                athlete.setDisciplinePoints(disciplinePoints);
                athletes.add(athlete);
            }

            definePlace(athletes);

            Collections.sort(athletes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return athletes;
    }

    private void definePlace(List<Athlete> athletes) {
        var totalPoints = athletes.stream()
                .map(Athlete::getTotalPoint)
                .sorted(Comparator.reverseOrder())
                .distinct().collect(Collectors.toList());

        var byTotalPointAthletes = athletes.stream()
                .collect(Collectors.groupingBy(Athlete::getTotalPoint));

        int place = 0;
        for (double totalPoint : totalPoints) {
            var list = byTotalPointAthletes.get(totalPoint);
            for (Athlete athlete : list) {
                if (list.size() > 1) {
                    athlete.setPlace((place + 1) + "-" + list.size());
                } else {
                    athlete.setPlace(String.valueOf(place + 1));
                }
            }
            place += list.size();
        }
    }

}
