package CarpoolingProyect.CarpoolingProyect.Service

import CarpoolingProyect.CarpoolingProyect.Global.SecretModule
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Service


@Service
class TokenService {
    fun create(subject: String): String{
        return Jwts.builder()
            .signWith(SecretModule.SECRET)
            .subject(subject)
            .compact()
    }

    fun verify(token: String): Claims{
        try {
            val claims = Jwts.parser().verifyWith(SecretModule.SECRET)
                .build().parseSignedClaims(token)
            return claims.payload
        }catch (err: Exception){
            throw Error("invalid token")
        }
    }
}