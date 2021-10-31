package com.example.toastutils

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.toaster.view.ToastView

class ViewActivity : AppCompatActivity() {

 private lateinit var toast_view : ToastView
 private lateinit var btnChnageColor : Button
 private lateinit var btnHide : Button
 private lateinit var btnShow : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        toast_view = findViewById(R.id.toast_view)
        btnChnageColor = findViewById(R.id.btnChnageColor)
        btnShow = findViewById(R.id.btnshow)
        btnHide = findViewById(R.id.btnHide)

        btnChnageColor.setOnClickListener {
            toast_view.changeTextColor(R.color.white)
        }
        btnShow.setOnClickListener {
            toast_view.showProgress()
        }
        btnHide.setOnClickListener {
            toast_view.hideProgress()
        }

    }
}