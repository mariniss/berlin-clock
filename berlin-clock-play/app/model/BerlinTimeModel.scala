package model

import play.api.libs.json.{Json, OFormat}

case class BerlinTimeModel(

  clockTwoSeconds: Boolean,

  hoursPerFive:(
    Boolean,
    Boolean,
    Boolean,
    Boolean
  ),

  hoursPerOne: (
    Boolean,
    Boolean,
    Boolean,
    Boolean
  ),

  minutesPerFive: (
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean,
    Boolean
  ),

  minutesPerOne: (
    Boolean,
    Boolean,
    Boolean,
    Boolean
  )
)

object BerlinTimeModel {
  implicit val berlinTimeModelFormat: OFormat[BerlinTimeModel] = Json.format[BerlinTimeModel]
}