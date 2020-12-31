package com.example.droidcafe;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
                implements TimePickerDialog.OnTimeSetListener  {

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        MainActivity activity = (MainActivity) getActivity();
        activity.timePickerIsSet(hourOfDay, minute);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        // Use the current date as the default date in the picker.
        final Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        // Create a new instance of DatePickerDialog and return it.
        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

}
