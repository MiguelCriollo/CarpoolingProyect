package CarpoolingProyect.CarpoolingProyect.Model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    var user:User?=null

    @JsonManagedReference
    @OneToMany(mappedBy = "driver",cascade = [CascadeType.ALL], orphanRemoval = true)
    var route:MutableSet<Route> = mutableSetOf()

    @JsonManagedReference
    @OneToOne(mappedBy = "driver",cascade = [CascadeType.ALL], orphanRemoval = true)
    var vehicle:Vehicle?=null
}