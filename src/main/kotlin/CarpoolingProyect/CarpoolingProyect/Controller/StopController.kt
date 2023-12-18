package CarpoolingProyect.CarpoolingProyect.Controller

import CarpoolingProyect.CarpoolingProyect.Model.Stop
import CarpoolingProyect.CarpoolingProyect.Service.StopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stops")
class StopController {
    @Autowired
    lateinit var stopService: StopService

    @GetMapping
    fun findAll() = stopService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = stopService.findById(id)

    @PostMapping
    fun save(stop: Stop) = stopService.save(stop)

    @DeleteMapping
    fun delete(id: Long) = stopService.delete(id)

    @PatchMapping
    fun patch(stop: Stop) = stopService.patch(stop)

    @PutMapping
    fun put(stop: Stop) = stopService.update(stop)
}