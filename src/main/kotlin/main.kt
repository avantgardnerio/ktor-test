import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }
        install(Routing) {
            get("/todo") {
                val author = Person("Alan", "Turing")
                call.respond(author)
            }
        }
    }.start(wait = true)
}