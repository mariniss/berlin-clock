package org.fm.berlinclock.service;

import org.fm.berlinclock.model.BerlinTimeModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
public class TimeRepresentationServiceTest {

    @Autowired
    private TimeRepresentationService service;


    @Test
    public void getBerlinRepresentationGetSecondsFlagTest() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.SECOND, 12);
        BerlinTimeModel result = service.getBerlinRepresentation(calendar);
        assertThat(result.getClockTwoSeconds()).isTrue();

        calendar.set(Calendar.SECOND, 15);
        result = service.getBerlinRepresentation(calendar);
        assertThat(result.getClockTwoSeconds()).isFalse();
    }
}
