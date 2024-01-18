package CarpoolingProyect.CarpoolingProyect.Model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank


@Entity
@Table(name = "stop")
class Stop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message = "El nombre de la parada es obligatorio")
    var name: String? = null

    @NotBlank(message = "La descripcion es obligatoria")
    var description: String? = null
}