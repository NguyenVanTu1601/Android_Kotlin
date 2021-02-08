package com.example.material_datepicker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Date Picker
        var calendar : Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.clear()
        var today : Long = MaterialDatePicker.todayInUtcMilliseconds()
        calendar.timeInMillis = today

        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        var january = calendar.timeInMillis

        calendar.set(Calendar.MONTH,Calendar.DECEMBER)
        var december = calendar.timeInMillis

        calendar.set(Calendar.MONTH,Calendar.MARCH)
        var march = calendar.timeInMillis

        // CalenderContraints
        var contraintBuider = CalendarConstraints.Builder()
        contraintBuider.setStart(january)
        contraintBuider.setEnd(december)
        //contraintBuider.setOpenAt(march) //mở 1 tháng định sẵn
        //contraintBuider.setValidator(DateValidatorPointForward.now())
        //contraintBuider.setValidator(DateValidatorPointForward.from(march))

        var buider = MaterialDatePicker.Builder.datePicker()
        buider.setTitleText("SELECT A DATE!")
        buider.setSelection(today)
        buider.setCalendarConstraints(contraintBuider.build())
        var materialDatePicker = buider.build()


        btnShowDatePicker.setOnClickListener {
            materialDatePicker.show(supportFragmentManager,"DATE_PICKER")
        }

        materialDatePicker.addOnPositiveButtonClickListener {
                selection -> select_date.text = getDate(selection, "dd/MM/yyyy")
        }

        // DateRangePicker
        var builder_new : MaterialDatePicker.Builder<Pair<Long, Long>> = MaterialDatePicker.Builder.dateRangePicker()
        builder_new.setTitleText("Select many date!")
        var materialDatePicker_new = builder_new.build()

        btnShowDatePickerNew.setOnClickListener(View.OnClickListener {
            materialDatePicker_new.show(supportFragmentManager, "DATE_PICKER_NEW")
        })


    }

    // Chuyển s nhân được từ datepicker sang định dạng ngày/tháng/năm
    fun getDate(milliSeconds: Long, dateFormat: String?): String {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar: Calendar = Calendar.getInstance()
        calendar.setTimeInMillis(milliSeconds)
        return formatter.format(calendar.getTime())
    }
}