package com.example.baitapthuchanh21


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        btnCheck.setOnClickListener {
            val email = edtEmail.text.toString().trim()

            when {
                email.isEmpty() -> {
                    tvMessage.text = "Email không hợp lệ"
                }
                !email.contains("@") -> {
                    tvMessage.text = "Email không đúng định dạng"
                }
                else -> {
                    tvMessage.text = "Bạn đã nhập email hợp lệ"
                }
            }
        }
    }
}
