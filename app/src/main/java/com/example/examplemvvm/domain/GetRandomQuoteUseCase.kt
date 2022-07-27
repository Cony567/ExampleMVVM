package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.ui.viewmodel.QuoteViewModel

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke() : QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}