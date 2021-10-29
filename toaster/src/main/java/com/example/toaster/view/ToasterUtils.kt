package com.example.toaster.view

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.toaster.R

class ToasterUtils {

     companion object {

         fun showRedToast(context: Context, string: String){
             var toast : Toast = Toast.makeText(context, string, Toast.LENGTH_SHORT)
             val view: View? = toast.view
             view?.setBackgroundColor(context.resources.getColor(R.color.red))
             toast.show()//show herejava -version
         }
     }
}