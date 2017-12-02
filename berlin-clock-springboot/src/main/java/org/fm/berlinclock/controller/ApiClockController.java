package org.fm.berlinclock.controller;

import org.fm.berlinclock.model.BerlinTimeModel;
import org.fm.berlinclock.service.TimeRepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/api")
public class ApiClockController {

    @Autowired
    private TimeRepresentationService timeRepresentationService;

    @RequestMapping("/clock/berlin")
    public BerlinTimeModel getBerlinTimeRepresentation() {
        return timeRepresentationService.getBerlinRepresentation(Calendar.getInstance());
    }

}
