package com.example.a_citra.belajar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenImage;

import java.util.List;


public class UbahProfil extends Fragment implements ImagePickerCallback {

    private Button btPickImageSingle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_ubah_profil, container, false);

        Button simpan = (Button) rootView.findViewById(R.id.simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new tab_fragment_profil(), "NewFragmentTag");
                    ft.addToBackStack(null);
                    ft.commitAllowingStateLoss();

                }
                catch (Exception e){

                }
            }
        });

        btPickImageSingle = (Button) rootView.findViewById(R.id.ubah_gambar);
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
    public void onImagesChosen(List<ChosenImage> list) {

    }

    @Override
    public void onError(String s) {

    }
}
