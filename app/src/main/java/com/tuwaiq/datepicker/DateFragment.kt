package com.tuwaiq.datepicker

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

const val DATE_KEY = "date"
class DateFragment : Fragment(), DatePickerFragment.DatePicker {

    private lateinit var dateBtn : Button
    private lateinit var dateTv: TextView

    private val date = Date()
    val format = "MMM dd, yyyy"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_date, container, false)

        dateBtn = view.findViewById(R.id.date_btn)
        dateTv = view.findViewById(R.id.date_tv)

        return view
    }

    override fun onStart() {
        super.onStart()

        dateBtn.setOnClickListener {

            val args = Bundle()
            args.putSerializable(DATE_KEY,date)

            val datePicker = DatePickerFragment()

            datePicker.arguments = args
            datePicker.setTargetFragment(this,0)
            datePicker.show(parentFragmentManager,"datePicker")


        }



    }

    override fun dateSelected(date: Date) {
        dateTv.text = DateFormat.format(format,date)
    }


}
