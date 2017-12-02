package controllers;

import models.BerlinTimeModel;
import play.libs.Json;
import play.mvc.Controller;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.mvc.Result;
import services.TimeRepresentationService;
import java.util.Calendar;

@Singleton
public class ApiClockController extends Controller {

    @Inject
    private TimeRepresentationService service;


    public Result getBerlinTimeRepresentation() {
        BerlinTimeModel representation = service.getBerlinRepresentation(Calendar.getInstance());

        return ok(Json.toJson(representation));
    }
}
