package CarpoolingProyect.CarpoolingProyect.Config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class CorsConfig: WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins(
                "http://localhost:8000",
                "http://localhost:5173")
            .allowedMethods("POST", "GET", "DELETE", "PATCH", "PUT")
            .allowCredentials(true)
    }
}