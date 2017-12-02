
import java.util.Calendar

import org.scalatestplus.play._
import services.TimeRepresentationServiceImpl

class TimeRepresentationServiceSpec extends PlaySpec {

  val service = new TimeRepresentationServiceImpl()

  "TimeRepresentationService" should {
    "get the correct clockTwoSeconds flag as true - 0" in {
      val data = Calendar.getInstance()
      data.set(Calendar.SECOND, 0)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.clockTwoSeconds mustBe true
    }
    "get the correct clockTwoSeconds flag as true - 2" in {
      val data = Calendar.getInstance()
      data.set(Calendar.SECOND, 2)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.clockTwoSeconds mustBe true
    }
    "get the correct clockTwoSeconds flag as true - 10" in {
      val data = Calendar.getInstance()
      data.set(Calendar.SECOND, 10)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.clockTwoSeconds mustBe true
    }

    "get the correct clockTwoSeconds flag as false - 1" in {
      val data = Calendar.getInstance()
      data.set(Calendar.SECOND, 1)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.clockTwoSeconds mustBe false
    }
    "get the correct clockTwoSeconds flag as false - 3" in {
      val data = Calendar.getInstance()
      data.set(Calendar.SECOND, 3)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.clockTwoSeconds mustBe false
    }
    "get the correct clockTwoSeconds flag as false - 9" in {
      val data = Calendar.getInstance()
      data.set(Calendar.SECOND, 9)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.clockTwoSeconds mustBe false
    }

    "get the correct hoursPerFive flags as false - 0" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 0)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (false, false, false, false)
    }
    "get the correct hoursPerFive flags as false - 3" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 3)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (false, false, false, false)
    }

    "get the correct hoursPerFive flags as true - 5" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 5)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, false, false, false)
    }
    "get the correct hoursPerFive flags as true - 8" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 8)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, false, false, false)
    }

    "get the correct hoursPerFive flags as true - 10" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 10)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, true, false, false)
    }
    "get the correct hoursPerFive flags as true - 12" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 12)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, true, false, false)
    }

    "get the correct hoursPerFive flags as true - 15" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 15)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, true, true, false)
    }
    "get the correct hoursPerFive flags as true - 18" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 18)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, true, true, false)
    }

    "get the correct hoursPerFive flags as true - 20" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 20)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, true, true, true)
    }
    "get the correct hoursPerFive flags as true - 23" in {
      val data = Calendar.getInstance()
      data.set(Calendar.HOUR_OF_DAY, 23)

      val result = service.getBerlinRepresentation(data)

      result must not be null
      result.hoursPerFive mustBe (true, true, true, true)
    }
  }
}
