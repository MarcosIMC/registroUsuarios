package Controller.BBDD

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class ConnectionBD {
// TODO tengo que mirar esto

    internal  var conn: Connection? = null
    val usuario = "root"
    val pass = ""
    val url = "jdbc:mysql://localhost:3306/usuarios"

    fun getConnection(): Connection? {
        val connProperties = Properties()

        connProperties.put("user", usuario)
        connProperties.put("password", pass)

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()

            conn = DriverManager.getConnection(url, connProperties)

        }catch (ex: SQLException){
            ex.printStackTrace()
        }catch (ex: Exception){
            ex.printStackTrace()
        }
        return conn
    }

    fun closeConnection(conn : Connection){
        if (conn != null){
            conn!!.close()
        }
    }
}