package f.fajrak.kotlin_base_project.tools

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DataBindingAdapters {

    companion object
    {


        @JvmStatic
        @BindingAdapter("validatedText")
        fun TextView.setValidatedText(text : String)
        {
            if(text.isNotEmpty())
            {
                this.text = text
            }
        }


    }
}