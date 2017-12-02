package org.fm.berlinclock

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class TimeRepresentationServiceSpec extends Specification implements ServiceUnitTest<TimeRepresentationService>{

    def setup() {}

    def cleanup() {}


    void "getBerlinRepresentation should return the correct second flag"() {
        given:
            Calendar calendar = Calendar.getInstance()
            calendar.set(Calendar.SECOND, seconds)

        when:
            def result = service.getBerlinRepresentation(calendar)

        then:
            result.clockTwoSeconds == flag

        where:
            seconds | flag
            0       | true
            1       | false
            4       | true
            5       | false
            8       | true
            9       | false
    }
}
