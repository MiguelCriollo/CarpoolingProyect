package CarpoolingProyect.CarpoolingProyect.Model
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
@Table(name = "users")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="Los nombres son obligatorios") //validate
    @Column(name="first_name")
    var firstName: String = ""

    @NotBlank(message="Los apellidos son Obligatorios") //validate
    @Column(name="last_name")
    var lastName: String= ""

    @NotBlank(message="El numero de Cedular es Obligatorio") //validate
    @Size(min=10, max = 10, message = "Numero de Celular Invalido")
    @Column(name="cell_number")
    var cellNumber: String =""

    @NotBlank(message="El correo electronico es obligatorio") //validate
    @Email(message="Correo no valido")
    var email:String=""

    //@field:Identification
    @NotBlank(message="Campo obligatorio") //validate
    var password:String="null"
        get() = field
        set(value){
            val encodedPassword = BCryptPasswordEncoder().encode(value)
            field = encodedPassword
        }

    @Column(name="is_driver")
    var isDriver:Boolean?=null;

    @Size(min=10, max = 10, message = "Numero de Cedula Invalido")
    @NotBlank(message="La cedula es obligatoria")
    var identification:String=""

    var status:String?="active";

    @Column(name = "role")
    var role:String?="admin"

    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}