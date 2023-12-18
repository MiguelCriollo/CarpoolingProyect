package CarpoolingProyect.CarpoolingProyect.Model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "route")
class Route {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "name")
    var name:String?=null

    @Column(name="start_date")
    var startDate:Date?=null

    @Column(name="description")
    var description:String?=null

    @Column(name="driver_id")
    var driverId:Long?=null
}