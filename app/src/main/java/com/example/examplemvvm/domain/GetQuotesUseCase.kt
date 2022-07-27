package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    //de esta forma se llama a un método por defecto de aun clase
    suspend operator fun invoke() : List<QuoteModel>? = repository.getAllQuotes()
}