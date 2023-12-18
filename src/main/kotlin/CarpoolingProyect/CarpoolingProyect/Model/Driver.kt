package CarpoolingProyect.CarpoolingProyect.Model

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
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="driver_licence")
    var driverLicence: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="user_id")
    var userId: Long?= null
}