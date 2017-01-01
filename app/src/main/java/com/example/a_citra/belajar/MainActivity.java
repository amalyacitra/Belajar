package com.example.a_citra.belajar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PickerAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        Log.d("Citra", "sampe sini");
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        toolbar.setTitle("Belajar");


        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        adapter = new PickerAdapter(getSupportFragmentManager());

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



    public void pilihKeluar(MenuItem item) {
        //Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(),sign_in.class);
                startActivity(intent);
                return true;
            }
        });
    }

    class PickerAdapter extends FragmentPagerAdapter {
        //Fragment timePickerFragment;
        Fragment datePickerFragmentBuatJanji;
        Fragment datePickerFragmentLapor;

        public PickerAdapter(FragmentManager fm) {
            super(fm);
            //timePickerFragment = new TimePickerFragment();
            datePickerFragmentBuatJanji = new tab_fragment_buat_janji();
            datePickerFragmentLapor = new tab_fragment_lapor();
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }


        @Override
        public int getCount() {
            return 0;
        }
    }

}
