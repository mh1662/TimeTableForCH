package com.mh1662.timetableCH

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.mh1662.timetableCH.databinding.DialogAddTimeBinding
import java.text.SimpleDateFormat
import java.util.*

class AddTimeDialog : DialogFragment() {
    private var _binding : DialogAddTimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogAddTimeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.addDialogStartTime.setOnClickListener {
            val startCal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener{ timePicker, hour, minute ->
                startCal.set(Calendar.HOUR_OF_DAY, hour)
                startCal.set(Calendar.MINUTE, minute)

                binding.addDialogStartTime.text = SimpleDateFormat("HH:mm").format(startCal.time)
            }

            TimePickerDialog(context, timeSetListener, startCal.get(Calendar.HOUR_OF_DAY), startCal.get(Calendar.MINUTE), true).show()
        }

        binding.addDialogEndTime.setOnClickListener {
            val endCal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener{ timePicker, hour, minute ->
                endCal.set(Calendar.HOUR_OF_DAY, hour)
                endCal.set(Calendar.MINUTE, minute)

                binding.addDialogEndTime.text = SimpleDateFormat("HH:mm").format(endCal.time)
            }

            TimePickerDialog(context, timeSetListener, endCal.get(Calendar.HOUR_OF_DAY), endCal.get(Calendar.MINUTE), true).show()
        }

        binding.addDialogButtonCancel.setOnClickListener{
            dismiss()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddTimeDialog().apply {
                arguments = Bundle().apply {
                }
            }
    }
}