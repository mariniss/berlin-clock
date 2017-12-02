import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status
import play.api.test.FakeRequest
import play.api.test.Helpers._


class FunctionalSpec extends PlaySpec with GuiceOneAppPerSuite {

  "Routes" should {

    "send 200 on root path" in  {
      val home = route(app, FakeRequest(GET, "/"))

      home.map(status(_)) mustBe Some(OK)
      home.map(contentType(_)) mustBe Some(Some("text/html"))
      //home.map(contentAsString(_)).get must include ("Berlin Clock - Current time")
    }

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    "send 200 on a good request" in  {
      route(app, FakeRequest(GET, "/")).map(status(_)) mustBe Some(OK)
    }

  }

  "ApiClockController" should {

    "return the berlin clock representation of now" in {
      val result = route(app, FakeRequest(GET, "/api/clock/berlin")).get

      status(result) mustBe Status.OK
      contentType(result) mustBe Some("application/json")
      contentAsString(result) must include ("clockTwoSeconds")
      contentAsString(result) must include ("hoursPerFive")
      contentAsString(result) must include ("hoursPerOne")
      contentAsString(result) must include ("minutesPerFive")
      contentAsString(result) must include ("minutesPerOne")
    }

  }
}
