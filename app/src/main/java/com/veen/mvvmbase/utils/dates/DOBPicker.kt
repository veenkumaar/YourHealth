package com.veen.mvvmbase.utils.dates

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.veen.mvvmbase.utils.CommonUtils.ELIGIBILITY
import java.util.Calendar
import java.util.GregorianCalendar

class DOBPicker : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private var date: StringBuilder? = null
    private var day: Int? = null
    private var setOnDateOfBirth: SetOnDateOfBirth? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        day = c.get(Calendar.DAY_OF_MONTH)
        val hideUnusedDate = DatePickerDialog(requireContext(), this, year, month, day!! - 0)
        hideUnusedDate.datePicker.maxDate = c.timeInMillis
        return hideUnusedDate
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        val userAge: Calendar = GregorianCalendar(year, month, day)
        val minAdultAge: Calendar = GregorianCalendar()
        minAdultAge.add(Calendar.YEAR, -18)
        if (minAdultAge.before(userAge)) {
            Toast.makeText(
                requireContext(),
                ELIGIBILITY,
                Toast.LENGTH_LONG
            )
                .show()
        } else {
            if (month.toString().length == 1 && day.toString().length == 1) {
                getDateWithBoth(year, month, day)
            } else {
                when {
                    month.toString().length == 1 -> {
                        getDateWithMonth(year, month, day)
                    }

                    day.toString().length == 1 -> {
                        getDateWithDay(year, month, day)
                    }

                    else -> {
                        getDateWithZero(year, month, day)
                    }
                }
            }
        }
    }

    fun setOnDateOfBirth(setOnDateOfBirth: SetOnDateOfBirth) {
        this.setOnDateOfBirth = setOnDateOfBirth
    }

    interface SetOnDateOfBirth {
        fun setDateOfBirth(date: StringBuilder?)
    }

    private fun getDateWithZero(year: Int, month: Int, day: Int) {
        date = StringBuilder().append(year)
            .append("-").append(month + 1).append("-").append(day)
            .append(" ")
        setOnDateOfBirth?.setDateOfBirth(date!!)
    }

    private fun getDateWithDay(year: Int, month: Int, day: Int) {
        date = StringBuilder().append(year)
            .append("-").append(month + 1).append("-0").append(day)
            .append(" ")
        setOnDateOfBirth?.setDateOfBirth(date!!)
    }

    private fun getDateWithMonth(year: Int, month: Int, day: Int) {
        date = StringBuilder().append(year)
            .append("-0").append(month + 1).append("-").append(day)
            .append(" ")
        setOnDateOfBirth?.setDateOfBirth(date!!)
    }

    private fun getDateWithBoth(year: Int, month: Int, day: Int) {
        date = StringBuilder().append(year)
            .append("-0").append(month + 1).append("-0").append(day)
            .append(" ")
        setOnDateOfBirth?.setDateOfBirth(date!!)
    }
}