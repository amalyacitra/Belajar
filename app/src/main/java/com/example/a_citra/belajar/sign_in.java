package com.example.a_citra.belajar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onMasukClick (View view){
        Intent getMasukIntent = new Intent(this, MainActivity.class);

        //final int result = 1;
        //getMasukIntent.putExtra("mainActivity", "MainActivity");
        //startActivityForResult(getMasukIntent, result);

        startActivity(getMasukIntent);
        finish();

    }

}

