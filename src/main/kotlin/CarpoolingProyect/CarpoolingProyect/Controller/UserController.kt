package CarpoolingProyect.CarpoolingProyect.Controller

import CarpoolingProyect.CarpoolingProyect.Model.User
import CarpoolingProyect.CarpoolingProyect.Service.UserService
import ch.qos.logback.core.net.server.Client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping()
    fun getAll():ResponseEntity<*>{
        return ResponseEntity(userService.listAllUsers(),HttpStatus.OK)
    }

    @PostMapping()
    fun createUser(@RequestBody user:User):ResponseEntity<User>{
        return ResponseEntity(userService.saveUser(user),HttpStatus.OK)
    }

    @PutMapping()
    fun updateUser(@RequestBody user:User):ResponseEntity<User>{
        return ResponseEntity(userService.update(user),HttpStatus.OK)
    }

    @PatchMapping()
    fun updateName(@RequestBody user:User):ResponseEntity<User>{
        return ResponseEntity(userService.updateCellNumber(user),HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id:Long?):ResponseEntity<User>{
        return ResponseEntity(userService.listById(id),HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteId(@PathVariable id:Long?):String{
        return userService.deleteId(id)
    }
}