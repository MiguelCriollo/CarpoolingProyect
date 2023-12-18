package CarpoolingProyect.CarpoolingProyect.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import org.springframework.data.annotation.Id

@Entity
@Table(name = "stop")
class Stop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id()
    var id: Long? = null

    var name: String? = null
    var description: String? = null
}