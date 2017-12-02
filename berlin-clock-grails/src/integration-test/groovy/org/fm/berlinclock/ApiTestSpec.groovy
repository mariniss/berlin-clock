package org.fm.berlinclock

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import org.fm.berlinclock.model.BerlinTimeModel
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@Integration
@Rollback
class ApiTestSpec extends Specification {

    @Value('${local.server.port}')
    Integer port

    private RestTemplate restTemplate

    def setup() {
        def builder = new RestTemplateBuilder()
        restTemplate = builder.build()
    }

    def cleanup() {}

    void "the api clock berlin should return the current time berlin representation "() {
        when:
            def result = restTemplate.getForObject("http://localhost:$port/api/clock/berlin", BerlinTimeModel.class)

        then:
        	result != null
    }
}
