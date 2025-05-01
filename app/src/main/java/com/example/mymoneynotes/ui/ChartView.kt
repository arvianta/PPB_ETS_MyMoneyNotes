package com.example.mymoneynotes.ui

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

@Composable
fun PieChartView(income: Float, expense: Float, isDarkMode: Boolean) {
    val chartTextColor = if (isDarkMode) ComposeColor.White else ComposeColor.Black

    AndroidView(
        factory = { context ->
            PieChart(context).apply {
                val entries = listOf(
                    PieEntry(income, "Income"),
                    PieEntry(expense, "Expense")
                )

                val dataSet = PieDataSet(entries, "").apply {
                    colors = listOf(Color.rgb(76, 175, 80), Color.rgb(244, 67, 54))
                    valueTextColor = chartTextColor.toArgb()
                    valueTextSize = 18f
                }

                data = PieData(dataSet)
                description.isEnabled = false

                legend.isEnabled = true
                legend.textSize = 16f
                legend.textColor = chartTextColor.toArgb()
                legend.formSize = 14f
                legend.xEntrySpace = 16f

                setUsePercentValues(true)
                animateY(1000)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    )
}
