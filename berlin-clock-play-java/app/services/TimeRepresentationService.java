package services;

import models.BerlinTimeModel;
import java.util.Calendar;

public interface TimeRepresentationService {
    BerlinTimeModel getBerlinRepresentation(Calendar time);
}