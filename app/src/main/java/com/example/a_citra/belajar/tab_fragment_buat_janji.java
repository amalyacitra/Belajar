package com.example.a_citra.belajar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.DialogFragment;

import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;


public class tab_fragment_buat_janji extends Fragment implements DatePickerDialog.OnDateSetListener  {

    private TextView dateTextView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public tab_fragment_buat_janji() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab_fragment_buat_janji, container, false);


        dateTextView = (TextView) rootView.findViewById(R.id.date_textview);
        Button dateButton = (Button) rootView.findViewById(R.id.date_button);

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
                //dpd.show(getActivity().getSupportFragmentManager(), "Datepickerdialog");
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getActivity().getSupportFragmentManager();
        if(dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "You picked the following date: "+dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        dateTextView.setText(date);
    }




}
