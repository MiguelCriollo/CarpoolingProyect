package CarpoolingProyect.CarpoolingProyect.Controller

import CarpoolingProyect.CarpoolingProyect.Model.Route
import CarpoolingProyect.CarpoolingProyect.Service.DriverService
import CarpoolingProyect.CarpoolingProyect.Service.RouteService
import CarpoolingProyect.CarpoolingProyect.Service.TokenService
import CarpoolingProyect.CarpoolingProyect.utils.getJwtCookie
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/route")
class RouteController {
    @Autowired
    private lateinit var tokenService: TokenService

    @Autowired
    lateinit var routeService: RouteService

    @GetMapping()
    fun getAll(): ResponseEntity<*> {
        return ResponseEntity(routeService.listAllUsers(), HttpStatus.OK)
    }

    @GetMapping("/userRoutes")
    fun getUserRoutes(requestServer: HttpServletRequest):ResponseEntity<*>{
        var jwt: Cookie = getJwtCookie(requestServer)
        var decodedId=tokenService.verify(jwt.value).subject.toLong()
        return ResponseEntity(routeService.listUserRoutes(decodedId),HttpStatus.OK)
    }

    @PostMapping()
    fun createRoute(@RequestBody route: Route,requestServer: HttpServletRequest): ResponseEntity<*> {
        var jwt: Cookie = getJwtCookie(requestServer)
        var decodedId=tokenService.verify(jwt.value).subject.toLong()
        return ResponseEntity(routeService.saveRoute(route,decodedId), HttpStatus.OK)
    }


    @PutMapping()
    fun updateUser(@RequestBody user: Route): ResponseEntity<Route> {
        return ResponseEntity(routeService.update(user), HttpStatus.OK)
    }

    @PatchMapping()
    fun updateName(@RequestBody user: Route): ResponseEntity<Route> {
        return ResponseEntity(routeService.updateDescription(user), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id:Long?): ResponseEntity<Route> {
        return ResponseEntity(routeService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteId(@PathVariable id:Long?):String{
        return routeService.deleteId(id)
    }
}