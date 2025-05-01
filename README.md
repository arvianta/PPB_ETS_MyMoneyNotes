# 💸 MyMoney Notes

**MyMoney Notes** is a personal finance tracker Android application built with **Kotlin** and **Jetpack Compose**.

This app allows users to record daily income and expenses, view financial summaries, and manually toggle between light and dark themes.

---

## 📱 Features

- ✅ Add transactions (Income or Expense)
- ✅ Input category and amount
- ✅ Display a list of all recent transactions
- ✅ Show total income, total expenses, and net balance
- ✅ Manual Light/Dark theme toggle
- ✅ (Optional) Pie chart for data visualization

---

## 🛠️ Built With

- **Language:** Kotlin
- **UI:** Jetpack Compose
- **State Management:** ViewModel, `remember`, `rememberSaveable`
- **Navigation:** Navigation Compose
- **Charting:** [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)

---

## 📁 Project Structure

```
app/
├── ui/
│   ├── HomeScreen.kt
│   ├── AddTransactionScreen.kt
│   ├── ChartView.kt
│   └── theme/ (Color.kt, Theme.kt, Type.kt)
├── model/
│   └── Transaction.kt, TransactionType.kt
├── viewmodel/
│   └── TransactionViewModel.kt
└── MainActivity.kt
```

---

## 🚀 Getting Started

1. Open this project in **Android Studio**
2. Connect an Android device or emulator
3. Press **Run ▶** to build and launch the app
4. To build an APK:
   ```
   Build > Build Bundle(s) / APK(s) > Build APK(s)
   ```

---