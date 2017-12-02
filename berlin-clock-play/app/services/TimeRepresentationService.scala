package services

import java.util.Calendar
import javax.inject._

import model.BerlinTimeModel

trait TimeRepresentationService {
  def getBerlinRepresentation(timeToRepresent: Calendar): BerlinTimeModel
}

@Singleton
class TimeRepresentationServiceImpl extends TimeRepresentationService {

  override def getBerlinRepresentation(timeToRepresent: Calendar): BerlinTimeModel = {
    val seconds = timeToRepresent.get(Calendar.SECOND)
    val hours = timeToRepresent.get(Calendar.HOUR_OF_DAY)
    val minutes = timeToRepresent.get(Calendar.MINUTE)

    val clockTwoSeconds = (seconds % 2) == 0

    val hoursPerFive = hours match {
      case h if h < 5   => (false, false, false, false)
      case h if h < 10  => (true,  false, false, false)
      case h if h < 15  => (true,  true,  false, false)
      case h if h < 20  => (true,  true,  true,  false)
      case _            => (true,  true,  true,  true) //>20
    }

    val hoursPerOne = hours match {
      case 0 | 5 | 10 | 15 | 20 => (false, false, false, false)
      case 1 | 6 | 11 | 16 | 21 => (true,  false, false, false)
      case 2 | 7 | 12 | 17 | 22 => (true,  true,  false, false)
      case 3 | 8 | 13 | 18 | 23 => (true,  true,  true,  false)
      case _                    => (true,  true,  true,  true) //4 | 9 | 14 | 19
    }

    val minutesPerFive = minutes match {
      case h if h < 5   => (false, false, false, false, false, false, false, false, false, false, false)
      case h if h < 10  => (true,  false, false, false, false, false, false, false, false, false, false)
      case h if h < 15  => (true,  true,  false, false, false, false, false, false, false, false, false)
      case h if h < 20  => (true,  true,  true,  false, false, false, false, false, false, false, false)
      case h if h < 25  => (true,  true,  true,  true,  false, false, false, false, false, false, false)
      case h if h < 30  => (true,  true,  true,  true,  true,  false, false, false, false, false, false)
      case h if h < 35  => (true,  true,  true,  true,  true,  true,  false, false, false, false, false)
      case h if h < 40  => (true,  true,  true,  true,  true,  true,  true,  false, false, false, false)
      case h if h < 45  => (true,  true,  true,  true,  true,  true,  true,  true,  false, false, false)
      case h if h < 50  => (true,  true,  true,  true,  true,  true,  true,  true,  true,  false, false)
      case h if h < 55  => (true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  false)
      case _            => (true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true) //>55
    }

    val minutesPerOne = minutes match {
      case 0 | 5 | 10 | 15 | 20 | 25 | 30 | 35 | 40 | 45 | 50 | 55 => (false, false, false, false)
      case 1 | 6 | 11 | 16 | 21 | 26 | 31 | 36 | 41 | 46 | 51 | 56 => (true,  false, false, false)
      case 2 | 7 | 12 | 17 | 22 | 27 | 32 | 37 | 42 | 47 | 52 | 57 => (true,  true,  false, false)
      case 3 | 8 | 13 | 18 | 23 | 28 | 33 | 38 | 43 | 48 | 53 | 58 => (true,  true,  true,  false)
      case _                                                       => (true,  true,  true,  true) //4 | 9 | 14 | 19 | 24 | 29 | 34 | 39 | 44 | 49 | 54 | 59
    }

    BerlinTimeModel(
      clockTwoSeconds = clockTwoSeconds,
      hoursPerFive= hoursPerFive,
      hoursPerOne = hoursPerOne,
      minutesPerFive = minutesPerFive,
      minutesPerOne = minutesPerOne)
  }
}
