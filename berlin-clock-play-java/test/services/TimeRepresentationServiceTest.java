package services;

import models.BerlinTimeModel;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;

public class TimeRepresentationServiceTest {

    private TimeRepresentationService service = new TimeRepresentationServiceImpl();

    @Test
    public void getBerlinRepresentationGetSecondsFlagTest() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.SECOND, 12);
        BerlinTimeModel result = service.getBerlinRepresentation(calendar);
        assertEquals(true, result.getClockTwoSeconds());

        calendar.set(Calendar.SECOND, 15);
        result = service.getBerlinRepresentation(calendar);
        assertEquals(false, result.getClockTwoSeconds());
    }
}
