package CarpoolingProyect.CarpoolingProyect.Model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name="vehicle")
class Vehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="plate")
    var plate: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="color")
    var color: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="model")
    var model: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="driver_id")
    var driverId: Long? = null

}
