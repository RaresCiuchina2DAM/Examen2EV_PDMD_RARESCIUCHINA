package com.example.examen2ev_pdmd_raresciuchina

import java.io.Serializable


class Movie : Serializable {

    lateinit var tituloPelicula: String
    var duracionMinutos : Int = 0
    var nombreDirector = ""
    var anyoLanzamiento :Int = 0
    var IdPelicula :Int = 0


}
