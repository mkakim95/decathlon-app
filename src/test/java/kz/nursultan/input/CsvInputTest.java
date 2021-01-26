package kz.nursultan.input;

import kz.nursultan.model.Athlete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvInputTest {

    @Test
    void definePlace() {
        Athlete athlete1 = new Athlete("Test1");
        athlete1.setTotalPoint(10);

        Athlete athlete2 = new Athlete("Test2");
        athlete2.setTotalPoint(10);

        Athlete athlete3 = new Athlete("Test3");
        athlete3.setTotalPoint(10);

        Athlete athlete4 = new Athlete("Test4");
        athlete4.setTotalPoint(15);

        Athlete athlete5 = new Athlete("Test5");
        athlete5.setTotalPoint(15);

        CsvInput csvInput = new CsvInput();
        var athletes = List.of(athlete1, athlete2, athlete3, athlete4, athlete5);
        csvInput.definePlace(athletes);

        Assertions.assertEquals("3-5", athletes.get(0).getPlace());
        Assertions.assertEquals("3-5", athletes.get(1).getPlace());
        Assertions.assertEquals("3-5", athletes.get(2).getPlace());
        Assertions.assertEquals("1-2", athletes.get(3).getPlace());
        Assertions.assertEquals("1-2", athletes.get(4).getPlace());
    }
}
