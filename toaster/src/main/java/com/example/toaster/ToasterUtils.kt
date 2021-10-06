package com.example.toaster

import android.content.Context
import android.view.View
import android.widget.Toast

class ToasterUtils {

     companion object {

         fun showRedToast(context: Context, string: String){
             var toast : Toast = Toast.makeText(context,string, Toast.LENGTH_SHORT)
             val view: View? = toast.view
             view?.setBackgroundColor(context.resources.getColor(R.color.red))
             toast.show()//show here
         }
     }
}