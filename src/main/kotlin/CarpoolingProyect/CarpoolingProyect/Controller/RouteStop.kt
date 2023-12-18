package CarpoolingProyect.CarpoolingProyect.Controller

import CarpoolingProyect.CarpoolingProyect.Service.RouteStopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/routes-stops")
class RouteStop {
    @Autowired
    lateinit var routeStopService: RouteStopService

    @GetMapping
    fun findAll() = routeStopService.findAll()
}