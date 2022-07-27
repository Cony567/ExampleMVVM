package com.example.examplemvvm.data

import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    //esta será la clase a la que se llame para que devuelva las citas
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        //guardar este response en memoria
        QuoteProvider.quotes = response
        return response
    }
}