package services;

import models.BerlinTimeModel;

import javax.inject.Singleton;
import java.util.Calendar;

@Singleton
public class TimeRepresentationServiceImpl implements TimeRepresentationService {

    @Override
    public BerlinTimeModel getBerlinRepresentation(Calendar time) {
        BerlinTimeModel model = new BerlinTimeModel();

        int seconds = time.get(Calendar.SECOND);
        int hours   = time.get(Calendar.HOUR_OF_DAY);
        int minutes = time.get(Calendar.MINUTE);

        model.setClockTwoSeconds((seconds % 2) == 0);

        if(hours < 5)       model.setHoursPerFive( new Boolean[] {false, false, false, false});
        else if(hours < 10) model.setHoursPerFive( new Boolean[] {true,  false, false, false});
        else if(hours < 15) model.setHoursPerFive( new Boolean[] {true,  true,  false, false});
        else if(hours < 20) model.setHoursPerFive( new Boolean[] {true,  true,  true,  false});
        else                model.setHoursPerFive( new Boolean[] {true,  true,  true,  true});

        if(hours == 0 || hours == 5 || hours == 10 || hours == 15 || hours == 20)
            model.setHoursPerOne( new Boolean[] {false, false, false, false});
        else if(hours == 1 || hours == 6 || hours == 11 || hours == 16 || hours == 21)
            model.setHoursPerOne( new Boolean[] {true,  false, false, false});
        else if(hours == 2 || hours == 7 || hours == 12 || hours == 17 || hours == 22)
            model.setHoursPerOne( new Boolean[] {true,  true,  false, false});
        else if(hours == 3 || hours == 8 || hours == 13 || hours == 18 || hours == 23)
            model.setHoursPerOne( new Boolean[] {true,  true,  true,  false});
        else
            model.setHoursPerOne( new Boolean[] {true,  true,  true,  true});

        if(minutes < 5)       model.setMinutesPerFive( new Boolean[] {false, false, false, false, false, false, false, false, false, false, false});
        else if(minutes < 10) model.setMinutesPerFive( new Boolean[] {true,  false, false, false, false, false, false, false, false, false, false});
        else if(minutes < 15) model.setMinutesPerFive( new Boolean[] {true,  true,  false, false, false, false, false, false, false, false, false});
        else if(minutes < 20) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  false, false, false, false, false, false, false, false});
        else if(minutes < 25) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  false, false, false, false, false, false, false});
        else if(minutes < 30) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  false, false, false, false, false, false});
        else if(minutes < 35) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  true,  false, false, false, false, false});
        else if(minutes < 40) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  true,  true,  false, false, false, false});
        else if(minutes < 45) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  true,  true,  true,  false, false, false});
        else if(minutes < 50) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false});
        else if(minutes < 55) model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  false});
        else                  model.setMinutesPerFive( new Boolean[] {true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true});

        if(minutes == 0 || minutes == 5 || minutes == 10 || minutes == 15 || minutes == 20 || minutes == 25
                || minutes == 30 || minutes == 35 || minutes == 40 || minutes == 45 || minutes == 50 || minutes == 55)
            model.setMinutesPerOne( new Boolean[] {false, false, false, false});
        else if(minutes == 1 || minutes == 6 || minutes == 11 || minutes == 16 || minutes == 21 || minutes == 26
                || minutes == 31 || minutes == 36 || minutes == 41 || minutes == 46 || minutes == 51 || minutes == 56)
            model.setMinutesPerOne( new Boolean[] {true,  false, false, false});
        else if(minutes == 2 || minutes == 7 || minutes == 12 || minutes == 17 || minutes == 22 || minutes == 27
                || minutes == 32 || minutes == 37 || minutes == 42 || minutes == 47 || minutes == 52 || minutes == 57)
            model.setMinutesPerOne( new Boolean[] {true,  true,  false, false});
        else if(minutes == 3 || minutes == 8 || minutes == 13 || minutes == 18 || minutes == 23 || minutes == 28
                || minutes == 33 || minutes == 38 || minutes == 43 || minutes == 48 || minutes == 53 || minutes == 58)
            model.setMinutesPerOne( new Boolean[] {true,  true,  true,  false});
        else
            model.setMinutesPerOne( new Boolean[] {true,  true,  true,  true});

        return model;
    }
}
