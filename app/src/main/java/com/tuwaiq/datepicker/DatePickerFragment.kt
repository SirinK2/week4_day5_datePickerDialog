package com.tuwaiq.datepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment: DialogFragment() {
    interface DatePicker{

        fun dateSelected(date: Date)

    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val date = arguments?.getSerializable(DATE_KEY) as Date

        val calendar = Calendar.getInstance()

        calendar.time = date

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dateListener = DatePickerDialog.OnDateSetListener { _, years, months, dayOfMonth ->

            val result = GregorianCalendar(years, months, dayOfMonth).time

            targetFragment.let {
                (it as DatePicker).dateSelected(result)
            }

        }

        return DatePickerDialog(requireContext(), dateListener, year, month, day)



    }







}