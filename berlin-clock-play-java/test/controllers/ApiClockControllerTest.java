package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;


public class ApiClockControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() { return new GuiceApplicationBuilder().build(); }

    @Test
    public void testClockBerlinApi() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(GET)
                .uri("/api/clock/berlin");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("application/json; charset=UTF-8", result.body().contentType().get());
    }
}
