package CarpoolingProyect.CarpoolingProyect.Model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.util.Date

@Entity
@Table(name = "route")
class Route {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message = "El nombre de la ruta es obligatorio")
    @Column(name = "name")
    var name:String?=null

    @NotBlank(message = "La fecha de inicio es obligatoria")
    @Column(name="start_date")
    var startDate:Date?=null

    @Column(name="description")
    var description:String?=null

    //@JsonIgnore
    @Column(name="driver_id")
    var driverId:Long?=null

    @JsonIgnore
    @OneToMany(mappedBy = "route",cascade = [CascadeType.ALL], orphanRemoval = true)
    var routeStop:MutableSet<RouteStop> = mutableSetOf()
}