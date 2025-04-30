package com.example.mymoneynotes.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.mymoneynotes.model.Transaction
import com.example.mymoneynotes.model.TransactionType
import java.text.SimpleDateFormat
import java.util.*

class TransactionViewModel : ViewModel() {

    // Mutable list of transactions
    private val _transactions = mutableStateListOf<Transaction>()
    val transactions: List<Transaction> get() = _transactions

    // For generating dummy IDs
    private var currentId = 0

    fun addTransaction(
        type: TransactionType,
        category: String,
        amount: Double
    ) {
        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())

        val transaction = Transaction(
            id = currentId++,
            type = type,
            category = category,
            amount = amount,
            date = currentDate
        )
        _transactions.add(transaction)
    }

    val totalIncome: Double
        get() = _transactions.filter { it.type == TransactionType.INCOME }
            .sumOf { it.amount }

    val totalExpense: Double
        get() = _transactions.filter { it.type == TransactionType.EXPENSE }
            .sumOf { it.amount }

    val netBalance: Double
        get() = totalIncome - totalExpense
}
