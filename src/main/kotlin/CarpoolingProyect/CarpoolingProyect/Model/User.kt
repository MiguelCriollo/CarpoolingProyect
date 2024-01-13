package CarpoolingProyect.CarpoolingProyect.Model
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
@Table(name = "users")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="first_name", length = 200)
    var firstName: String? = null

    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="last_name", length = 200)
    var lastName: String?= null

    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="cell_number", length = 10)
    var cellNumber: String? =null

    @NotBlank(message="Campo obligatorio")
    @Column(length = 100)//validate
    @Email(message="Correo Valido???Noze")
    var email:String?=null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(length = 30)
    var password:String?=null
        get() = field
        set(value){
            val encodedPassword = BCryptPasswordEncoder().encode(value)
            field = encodedPassword
        }

    @Column(name="is_driver")
    var isDriver:Boolean?=false

    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="identification", length = 10)
    var identification:String?=null

    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}