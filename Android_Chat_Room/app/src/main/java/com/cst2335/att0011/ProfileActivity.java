package com.cst2335.att0011;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "PROFILE_ACTIVITY";
    ImageButton imge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.e(TAG, "In function:" + "onCreate" );
        Intent fromMain = getIntent();
         EditText editEmailText = findViewById(R.id.editEmailText);
        editEmailText.setText( fromMain.getStringExtra("EMAIL"));
        imge = findViewById(R.id.imageButton);
        imge.setOnClickListener(v ->dispatchTakePictureIntent());
        /**
         * For Chat button
         */
        Button  chat_btn = findViewById(R.id.button);
        chat_btn.setOnClickListener((v) -> {
            Intent goToChat = new Intent( ProfileActivity.this, ChatRoomActivity.class);
            startActivity(goToChat);

        });
    }
     private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                myPictureTakerLauncher.launch(takePictureIntent);
            }
        }

        ActivityResultLauncher<Intent> myPictureTakerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult()
            ,new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.e(TAG, "In function:" + "onActivityResult");
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");

                        imge.setImageBitmap(imgbitmap);

                    }
                    else if(result.getResultCode() == Activity.RESULT_CANCELED)
                        Log.i(TAG, "User refused to capture a picture.");
                }
            } );
    @Override
    public void onStart(){
 super.onStart();
        Log.e(TAG, "In function:" + "onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.e(TAG, "In function:" + "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.e(TAG, "In function:" + "onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.e(TAG, "In function:" + "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e(TAG, "In function:" + "onDestroy");
    }
}
