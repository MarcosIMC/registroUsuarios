package Controller.BBDD

import Model.Usuario
import View.Listado
import java.sql.PreparedStatement
import java.sql.ResultSet
import javax.swing.table.DefaultTableModel

class ActionUserBD {
    var connDB = ConnectionBD()

    fun insertUser(user : Usuario){
        var conn = connDB.getConnection()

        if (conn != null){
            var stmt: PreparedStatement? = null
            var queryInsert = "INSERT INTO users VALUES (0,?,?,?,?)"

            stmt =  conn.prepareStatement(queryInsert)

            stmt.setString(1, user.Nombre)
            stmt.setString(2, user.Apellidos)
            stmt.setString(3, user.edad.toString())
            stmt.setString(4, user.altura.toString())

            stmt.executeUpdate()

            stmt.close()
            connDB.closeConnection(conn)
        }
    }

    fun getAllUsers(): DefaultTableModel? {
        var conn = connDB.getConnection()
        var resulSet: ResultSet? = null
        var modelo: DefaultTableModel? = null

        if (conn != null){
            var stmt: PreparedStatement? = null
            var querySelectUsers = "SELECT * FROM users"

            stmt = conn.prepareStatement(querySelectUsers)

            stmt.executeQuery()

            resulSet = stmt.resultSet

            val titulosTabla = arrayOf("Nombre", "Apellidos", "Edad", "Altura")
            var registros = arrayOfNulls<String>(4)

            modelo = DefaultTableModel (null, titulosTabla)

            while (resulSet.next()){
                //println("Nombre: "+resulSet.getString("nombre"))
                registros[0] = resulSet.getString("nombre")
                registros[1] = resulSet.getString("apellidos")
                registros[2] = resulSet.getString("edad")
                registros[3] = resulSet.getString("altura")

                modelo.addRow(registros)
            }

            stmt.close()
            connDB.closeConnection(conn)
        }

        return modelo!!
    }
}