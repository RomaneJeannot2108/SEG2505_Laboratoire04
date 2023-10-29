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

    //fonction OnClick pour ouvrir Google Maps
    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText)findViewById(R.id.teamAddressField);

        //Create a Uri from an intent string. Use the result to create an Intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());

        //Create an intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW.gmmIntentUri);

        //Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        //Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);

    }

    //fonction OnClick pour choisir le logo
    public void OnSetAvatarButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_CANCELED) return;

        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch(data.getIntExtra("imageID",R.id.logo0));
        case R.id.logo0:
            drawableName = "ic_logo_00";
            break;
        case R.id.logo1:
            drawableName = "ic_logo_01";
            break;
        case R.id.logo2:
            drawableName = "ic_logo_02";
            break;
        case R.id.logo3:
            drawableName = "ic_logo_03";
            break;
            case R.id.logo4:
            drawableName = "ic_logo_04";
        break;
        case R.id.logo5:
            drawableName = "ic_logo_05";
            break;
        default:
            drawableName = "ic_logo_00";
            break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable". getPackageName());
        avatarImage.setImageResource(resID);


}