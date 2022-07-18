package com.cst2335.att0011;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // Defining the object for button
    //Button btn;
    private EditText email;
    Switch on_off;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.EmailAddress2);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("email", "");
        email.setText(s1);

        Button btn = findViewById(R.id.button5);

        btn.setOnClickListener((v) -> {
            Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
            goToProfile.putExtra("EMAIL",email.getText().toString());

            startActivity(goToProfile);

        });

//        btn.setOnClickListener( {
//            @Override
//            public void onClick (View v){
//                Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
//                goToProfile.putExtra("EMAIL", "");
//                startActivity(goToProfile);
//
//            }
//        } );
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
        myEdit.putString("email", email.getText().toString());
        myEdit.commit();

    }
}
