package Model

class Usuario {
    var Nombre:String = ""
    var Apellidos:String = ""
    var edad:Int = 0
    var altura:Float = 0.0F

    constructor(Nombre: String, Apellidos: String, edad: Int, altura: Float) {
        this.Nombre = Nombre
        this.Apellidos = Apellidos
        this.edad = edad
        this.altura = altura
    }
}