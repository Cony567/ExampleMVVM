package com.example.examplemvvm.data.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*Constanza Castillo ultima actualización 05-07-2022 */
class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes() : List<QuoteModel> {
        //se crea una corrutina para hacer la llamada en un hilo secundario y no saturar la UI,
        // y cuando se cargue lo devolverá a quien lo necesite o lo esté llamando
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}