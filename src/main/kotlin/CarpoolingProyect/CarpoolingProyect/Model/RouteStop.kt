package CarpoolingProyect.CarpoolingProyect.Model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.util.Date

@Entity
@Table(name = "route_stop")
class RouteStop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null

    var position: Long? = null

    @NotBlank(message = "La hora de llegada es obligatoria")
    @Column(name="arrive_hour")
    var arriveHour: Date? = null

    //@JsonIgnore
    @Column(name="stop_id")
    var stopId: Long? = null

    //@JsonIgnore
    @Column(name = "route_id")
    var routeId: Long? = null
}