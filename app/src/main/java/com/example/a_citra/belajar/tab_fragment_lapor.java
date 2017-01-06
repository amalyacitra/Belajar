package com.example.a_citra.belajar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

import static android.R.id.message;


public class tab_fragment_lapor extends Fragment implements DatePickerDialog.OnDateSetListener, ImagePickerCallback {

    private TextView dateTextView;

    private ListView lvResults;
    private Button btPickImageSingle;
    private Button btPickImageMultiple;
    private Button btTakePicture;
    private String pickerPath;


    public tab_fragment_lapor() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab_fragment_lapor, container, false);

        dateTextView = (TextView) rootView.findViewById(R.id.date_textview);
        Button dateButton = (Button) rootView.findViewById(R.id.date_button);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        tab_fragment_lapor.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });

        btPickImageSingle = (Button) rootView.findViewById(R.id.buttonChoose);
        btPickImageSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageSingle();
            }
        });

        return rootView;
    }

    private ImagePicker imagePicker;
    private void pickImageSingle() {
        imagePicker = new ImagePicker(this);
        imagePicker.shouldGenerateMetadata(true);
        imagePicker.shouldGenerateThumbnails(true);
        imagePicker.setImagePickerCallback(this);
        imagePicker.pickImage();
    }


    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getActivity().getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        dateTextView.setText(date);
    }


    @Override
    public void onImagesChosen(List<ChosenImage> list) {

    }

    @Override
    public void onError(String s) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
