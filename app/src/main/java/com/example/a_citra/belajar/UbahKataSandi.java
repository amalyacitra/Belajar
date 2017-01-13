package com.example.a_citra.belajar;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class UbahKataSandi extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_ubah_kata_sandi, container, false);

        Button simpan = (Button) rootView.findViewById(R.id.simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new tab_fragment_profil(), "NewFragmentTag");
                    ft.addToBackStack(null);
                    ft.commitAllowingStateLoss();
                    //MessageBox("Perubahan disimpan");
                }
                catch (Exception e){

                }
            }
        });

        return rootView;
    }

    public void MessageBox(String message)
    {
        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
