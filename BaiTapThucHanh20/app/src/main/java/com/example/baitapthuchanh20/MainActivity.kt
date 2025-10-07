package com.example.baitapthuchanh20

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val tvError = findViewById<TextView>(R.id.tvError)
        val layoutButtons = findViewById<LinearLayout>(R.id.layoutButtons)

        btnCreate.setOnClickListener {
            val input = edtNumber.text.toString()
            val number = input.toIntOrNull()   // an toàn hơn, tránh try-catch

            if (number != null && number > 0) {
                tvError.visibility = View.GONE
                layoutButtons.removeAllViews()

                repeat(number) { i ->
                    val button = Button(this).apply {
                        text = "${i + 1}"
                        setTextColor(resources.getColor(android.R.color.white))
                        background = resources.getDrawable(R.drawable.button_bg)
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        ).apply { setMargins(0, 12, 0, 12) }
                    }
                    layoutButtons.addView(button)
                }
            } else {
                tvError.text = "Dữ liệu bạn nhập không hợp lệ"
                tvError.visibility = View.VISIBLE
                layoutButtons.removeAllViews()
            }
        }
    }
}
