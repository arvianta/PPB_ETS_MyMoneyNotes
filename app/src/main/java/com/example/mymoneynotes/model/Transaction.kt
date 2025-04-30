package com.example.mymoneynotes.model

enum class TransactionType {
    INCOME,
    EXPENSE
}

data class Transaction(
    val id: Int,
    val type: TransactionType,
    val category: String,
    val amount: Double,
    val date: String // Later we can auto-fill this using DateFormatter
)
