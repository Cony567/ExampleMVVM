package com.example.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.domain.GetQuotesUseCase
import com.example.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

//implementa la lógica del view model
class QuoteViewModel : ViewModel(){
    //se utiliza livedata porque este se suscribe a un modelo de datos y que se llama inmediatamente cuando se ejecuta un cambio en nuestro modelo
    val quoteModel = MutableLiveData<QuoteModel>() // se crea un mutable del modelo de datos que realmente queremos
    // lo que se hace es encapsular el modelo que se desea utilizar en el livedata, y es mutable porque tiene que ir cambiando
    val isLoading = MutableLiveData<Boolean>()

    //Casos de Uso
    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        //en este método se hace la llamada al caso de uso
        // viewModelScope crea una coorrutina
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null){
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)
    }
}