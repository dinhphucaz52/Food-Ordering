package com.example.foodordering.ui.screen.manager.home

import com.example.foodordering.ui.screen.manager.home.data.Invoice

object FakeData {
    fun provideInvoices(): List<Invoice> {
        return listOf(
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
            Invoice(),
        )
    }
}