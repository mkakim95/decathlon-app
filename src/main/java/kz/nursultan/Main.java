package kz.nursultan;

import kz.nursultan.input.CsvInput;
import kz.nursultan.output.XmlCreator;

public class Main {
    public static void main(String[] args) {
        var csv = new CsvInput();
        var athletes = csv.getAthletes();
        XmlCreator.create(athletes);
    }
}
