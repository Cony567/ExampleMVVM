package com.example.examplemvvm.data.model

//Constanza Castillo, ultima actualización 04-07-2022
//clase provider que le va a entregar informacion de las frases y autor al view model
//su funcion es simular roomDB
class QuoteProvider {
    //listado de las citas
    //para acceder al la clase se tiene que crear el companion object para poder acceder
    companion object { // se esta forma deja de ser una clase estática
        var quotes: List<QuoteModel> = emptyList()
    }
}