package org.fm.berlinclock

import grails.converters.JSON
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.fm.berlinclock.model.BerlinTimeModel

@Api(value = "/api/clock", tags = ["Clock"], description = "Clock Api's")
class ApiClockController {

    static namespace = 'v1'

    def timeRepresentationService

    @ApiOperation(
            value = "Berlin clock representation",
            nickname = "clock/berlin",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "GET",
            response = BerlinTimeModel.class
    )
    @ApiResponses([
            @ApiResponse(code = 405,
                    message = "Method Not Allowed. Only GET is allowed"),

            @ApiResponse(code = 404,
                    message = "Method Not Found")
    ])
    def getBerlinTimeRepresentation() {
        render timeRepresentationService.getBerlinRepresentation(Calendar.getInstance()) as JSON
    }
}
