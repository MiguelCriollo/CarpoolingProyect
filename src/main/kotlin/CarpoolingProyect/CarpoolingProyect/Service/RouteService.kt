package CarpoolingProyect.CarpoolingProyect.Service

import CarpoolingProyect.CarpoolingProyect.Dto.SuccessfulCreation
import CarpoolingProyect.CarpoolingProyect.Dto.SuccessfulResponse
import CarpoolingProyect.CarpoolingProyect.Exceptions.NotFoundResponse
import CarpoolingProyect.CarpoolingProyect.Model.Route
import CarpoolingProyect.CarpoolingProyect.Repository.DriverRepository
import CarpoolingProyect.CarpoolingProyect.Repository.RouteRepository
import CarpoolingProyect.CarpoolingProyect.Repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class RouteService {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    lateinit var routeRepository: RouteRepository

    @Autowired
    lateinit var driverRepository: DriverRepository

    //Basic Cruds
    fun listAllUsers():List<Route>{
        return routeRepository.findAll()
    }

    fun listUserRoutes(id:Long):SuccessfulResponse{
        val user=userRepository.findById(id).get()
        val allo= user.driver!!.route
        val userRoutes=routeRepository.findByDriverId(user.driver!!.id)
        if(userRoutes.isNotEmpty()){
            return SuccessfulResponse(data = userRoutes)
        }else{
            throw NotFoundResponse(message = "El usuario no tiene rutas creadas")
        }
    }
    @Transactional
    fun saveRoute(route: Route,id: Long): SuccessfulCreation {
        val user=userRepository.findById(id).get()
        val driver=driverRepository.findById(user.driver!!.id)
        driver!!.route.add(route)
        route.driver=driver
        driverRepository.save(driver)
        routeRepository.save(route)
        return SuccessfulCreation(message = "Routa Creada Exitosamente")

    }

    fun update(user: Route): Route {
        return routeRepository.save(user)
    }

    fun updateDescription(user: Route): Route {
        val response = routeRepository.findById(user.id)?:throw Exception("Id no existe")
        response.apply {
            description=user.description
        }
        return routeRepository.save(response)

    }

    fun listById(id: Long?): Route {
        return routeRepository.findById(id) ?: throw Exception("Id no existe")
    }

    fun deleteId(id:Long?):String{
        try{
            routeRepository.findById(id)
                ?: throw Exception("ID no existe")
            routeRepository.deleteById(id!!)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}