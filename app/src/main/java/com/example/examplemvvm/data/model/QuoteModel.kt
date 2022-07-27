package com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

//Constanza Castillo 04/07/2022
//modelo de datos
//en caso de que lo que se reciba de la BD o de la api no tenga los mismos nombres de atrubutos
// se tiene que utilizar @SerializedName con el nombre al que va a recibir
data class QuoteModel(@SerializedName("quote") val quote:String, val author:String)