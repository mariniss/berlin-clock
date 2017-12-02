package controllers

import java.util.Calendar
import javax.inject._

import akka.actor.ActorSystem
import model.BerlinTimeModel
import play.api.libs.json.Json
import play.api.mvc._
import services.TimeRepresentationService

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class ApiClockController @Inject()(cc: ControllerComponents, timeRepresentationService: TimeRepresentationService, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  def getBerlinTimeRepresentation = Action.async {
    getFutureTimeRepresentation(Calendar.getInstance())
      .map { result => Ok(Json.toJson(result)) }
  }


  private def getFutureTimeRepresentation(timeToRepresent: Calendar) = Future[BerlinTimeModel] {
    timeRepresentationService.getBerlinRepresentation(timeToRepresent)
  }
}
