package com.example.mymoneynotes.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mymoneynotes.model.Transaction
import com.example.mymoneynotes.viewmodel.TransactionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: TransactionViewModel, onAddClick: () -> Unit) {
    val transactions = viewModel.transactions

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MyMoney Notes") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Totals Summary
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "Total Income: Rp %.0f".format(viewModel.totalIncome),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Total Expense: Rp %.0f".format(viewModel.totalExpense),
                        color = MaterialTheme.colorScheme.error
                    )
                    Text(
                        text = "Net Balance: Rp %.0f".format(viewModel.netBalance)
                    )
                }
            }

            // Pie Chart
            Text(
                text = "Income vs Expense",
                style = MaterialTheme.typography.titleMedium
            )
            PieChartView(
                income = viewModel.totalIncome.toFloat(),
                expense = viewModel.totalExpense.toFloat()
            )

            // Transaction list
            if (transactions.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No transactions yet.")
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    items(transactions) { transaction ->
                        TransactionItem(transaction)
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "${transaction.type}: ${transaction.category}",
                style = MaterialTheme.typography.titleMedium
            )
            Text("Amount: Rp %.0f".format(transaction.amount))
            Text("Date: ${transaction.date}")
        }
    }
}
