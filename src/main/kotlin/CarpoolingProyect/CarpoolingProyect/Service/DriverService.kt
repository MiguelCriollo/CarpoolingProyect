package CarpoolingProyect.CarpoolingProyect.Service

import CarpoolingProyect.CarpoolingProyect.Model.Driver
import CarpoolingProyect.CarpoolingProyect.Repository.DriverRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DriverService {
    @Autowired
    lateinit var driverRepository: DriverRepository

    //Basic Cruds
    fun listAllUsers():List<Driver>{
        return driverRepository.findAll()
    }

    fun saveUser(user: Driver): Driver {
        return driverRepository.save(user);
    }

    fun update(user: Driver): Driver {
        return driverRepository.save(user)
    }

    fun updateLicence(user: Driver): Driver {
        val response = driverRepository.findById(user.id)?:throw Exception("Id no existe")
        response.apply {
            driverLicence=user.driverLicence
        }
        return driverRepository.save(response)

    }

    fun listById(id: Long?): Driver {
        return driverRepository.findById(id) ?: throw Exception("Id no existe")
    }

    fun deleteId(id:Long?):String{
        try{
            driverRepository.findById(id)
                ?: throw Exception("ID no existe")
            driverRepository.deleteById(id!!)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}