package CarpoolingProyect.CarpoolingProyect.Service

import CarpoolingProyect.CarpoolingProyect.Model.Route
import CarpoolingProyect.CarpoolingProyect.Repository.DriverRepository
import CarpoolingProyect.CarpoolingProyect.Repository.RouteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RouteService {
    @Autowired
    lateinit var routeRepository: RouteRepository

    //Basic Cruds
    fun listAllUsers():List<Route>{
        return routeRepository.findAll()
    }


    fun saveUser(user: Route): Route {
        return routeRepository.save(user);
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