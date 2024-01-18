package CarpoolingProyect.CarpoolingProyect.Model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
@Entity
@Table(name = "driver")
class Driver {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="La licencia es obligatoria")
    @Column(name="driver_licence")
    var driverLicence: String? = null

    //@JsonIgnore
    @Column(name="user_id")
    var userId: Long?= null
}