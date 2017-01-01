package com.example.a_citra.belajar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;


public class tab_fragment_buat_janji extends Fragment implements DatePickerDialog.OnDateSetListener,

        TimePickerDialog.OnTimeSetListener{


    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
      //                       Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.activity_tab_fragment_buat_janji, container, false);
        //return rootView;

    //}

    private TextView dateTextView;
    private TextView timeTextView;
    private CheckBox mode24Hours;

    public tab_fragment_buat_janji() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab_fragment_buat_janji, container, false);

        dateTextView = (TextView) view.findViewById(R.id.date_textview);
        Button dateButton = (Button) view.findViewById(R.id.date_button);

        timeTextView = (TextView) view.findViewById(R.id.time_textview);
        Button timeButton = (Button) view.findViewById(R.id.time_button);
        mode24Hours = (CheckBox) view.findViewById(R.id.mode_24_hours);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        tab_fragment_buat_janji.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        tab_fragment_buat_janji.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        mode24Hours.isChecked()
                );
                tpd.show(getActivity().getFragmentManager(), "Timepickerdialog");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getActivity().getFragmentManager().findFragmentByTag("Datepickerdialog");
        TimePickerDialog tpd = (TimePickerDialog) getActivity().getFragmentManager().findFragmentByTag("Timepickerdialog");
        if(tpd != null) tpd.setOnTimeSetListener(this);
        if(dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        dateTextView.setText(date);
    }


    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String secondString = second < 10 ? "0"+second : ""+second;
        String time = hourString+" : "+minuteString+" : "+secondString;
        timeTextView.setText(time);
    }
}
