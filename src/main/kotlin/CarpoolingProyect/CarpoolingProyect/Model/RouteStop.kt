package CarpoolingProyect.CarpoolingProyect.Model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "route_stop")
class RouteStop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null

    var position: Long? = null

    @Column(name="arrive_hour")
    var arriveHour: Date? = null

    @Column(name="stop_id")
    var stopId: Long? = null

    @Column(name = "route_id")
    var routeId: Long? = null
}