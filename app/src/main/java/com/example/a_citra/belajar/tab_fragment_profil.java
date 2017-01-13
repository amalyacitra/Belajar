package com.example.a_citra.belajar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class tab_fragment_profil extends Fragment {

    Button ubahKataSandi;
    Button ubahProfil;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_tab_fragment_profil, container, false);

        Button ubahKataSandi = (Button) rootView.findViewById(R.id.ubah_kata_sandi);
        ubahKataSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new UbahKataSandi(), "NewFragmentTag");
                    ft.addToBackStack(null);
                    ft.commitAllowingStateLoss();

                }
                catch (Exception e){

                }
            }
        });

        Button ubahProfil = (Button) rootView.findViewById(R.id.ubah_profil);
        ubahProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.framelayout, new UbahProfil(), "NewFragmentTag");
                    ft.addToBackStack(null);
                    ft.commitAllowingStateLoss();

                }
                catch (Exception e){

                }
            }
        });

        return rootView;
    }


}
