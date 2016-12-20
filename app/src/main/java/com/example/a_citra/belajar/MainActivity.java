package com.example.a_citra.belajar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.support.v4.app.Fragment;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        Log.d("Citra", "sampe sini");
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        toolbar.setTitle("Main Menu");

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId==R.id.tab_buat_janji){
                    Fragment fBuatJanji = new tab_fragment_buat_janji();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fBuatJanji).commit();

                }
                else if(tabId==R.id.tab_lapor){
                    Fragment fLapor = new tab_fragment_lapor();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fLapor).commit();
                }
                else if(tabId==R.id.tab_profil){
                    Fragment fProfil = new tab_fragment_profil();
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fProfil).commit();
                }
            }
        });

    }

    public void onKeluarClick(View view) {

    }


}
