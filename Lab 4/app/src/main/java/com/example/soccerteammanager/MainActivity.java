package com.example.soccerteammanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Function OnClick to open Google Maps
    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = findViewById(R.id.teamAddressField);

        // Create a Uri from an intent string. Use the result to create an Intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        // Create an intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    // Function OnClick to choose the logo
    public void OnSetAvatarButton(View view) {
        // Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        ImageView avatarImage = findViewById(R.id.avatarImage);
        int imageID = data.getIntExtra("imageID", R.id.logo0);
        String drawableName;

        if (imageID == R.id.logo0) {
            drawableName = "ic_logo_00";
        } else if (imageID == R.id.logo1) {
            drawableName = "ic_logo_01";
        } else if (imageID == R.id.logo2) {
            drawableName = "ic_logo_02";
        } else if (imageID == R.id.logo3) {
            drawableName = "ic_logo_03";
        } else if (imageID == R.id.logo4) {
            drawableName = "ic_logo_04";
        } else if (imageID == R.id.logo5) {
            drawableName = "ic_logo_05";
        } else {
            drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}
