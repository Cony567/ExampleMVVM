package com.example.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.model.QuoteModel
import com.example.examplemvvm.model.QuoteProvider

//implementa la lógica del view model
class QuoteViewModel : ViewModel(){
    //se utiliza livedata porque este se suscribe a un modelo de datos y que se llama inmediatamente cuando se ejecuta un cambio en nuestro modelo
    val quoteModel = MutableLiveData<QuoteModel>() // se crea un mutable del modelo de datos que realmente queremos
    // lo que se hace es encapsular el modelo que se desea utilizar en el livedata, y es mutable porque tiene que ir cambiando

    fun randomQuote(){
        //primero se llama al provider para que entregue la nota de manera random
        val currentQuote = QuoteProvider.random()
        // de esta manera se le cambia el valor a mutable
        quoteModel.postValue(currentQuote)
        //así el view model avisa a la vista que han surgido cambios para que los actualice
    }
}