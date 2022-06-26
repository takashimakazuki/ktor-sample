package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.statement.SqlQuery

val jdbi = Jdbi.create("jdbc:postgresql://localhost:5435/ktor_postgres","postgres","postgres").installPlugin(
    SqlObjectPlugin()
)
interface TodoDao {
    @SqlQuery("SELECT title from Todo")
    fun selectTodoList(): List<String>
}
fun Application.configureRouting() {

    routing {
        get("/") {
            val todoDao: TodoDao = jdbi.onDemand(TodoDao::class.java)
            val titles = todoDao.selectTodoList()
            call.respond(titles.joinToString())
        }
    }
}
