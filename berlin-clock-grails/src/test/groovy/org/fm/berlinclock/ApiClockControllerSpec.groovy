package org.fm.berlinclock

import grails.testing.web.controllers.ControllerUnitTest
import org.fm.berlinclock.model.BerlinTimeModel
import spock.lang.Specification

class ApiClockControllerSpec extends Specification implements ControllerUnitTest<ApiClockController> {

    def setup() {}

    def cleanup() {}

    void "getBerlinTimeRepresentation should return the berlin clock representation for the current time"() {
        given:
            controller.timeRepresentationService = Stub(TimeRepresentationService) {
                getBerlinRepresentation(_) >> new BerlinTimeModel(clockTwoSeconds: true)
            }

        when:
            controller.getBerlinTimeRepresentation()

        then:
            response.json.clockTwoSeconds == true
    }
}
