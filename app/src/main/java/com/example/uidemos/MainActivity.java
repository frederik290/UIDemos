package com.example.uidemos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_PICKER = 1;
    public static final int REQUEST_EDIT_TEXT = 2;
    public static final int REQUEST_SLIDE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPickerActivity(View view){
        Intent intent = new Intent(this, PickerActivity.class);
        startActivityForResult(intent, REQUEST_PICKER);

    }

    public void startEditTextActivity(View view){
        Intent intent = new Intent(this, EditTextActivity.class);
        startActivityForResult(intent, REQUEST_EDIT_TEXT);

    }

    public void startSlideActivity(View view){
        Intent intent = new Intent(this, SlideActivity.class);
        startActivityForResult(intent, REQUEST_SLIDE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Context context = getApplicationContext();

        if(requestCode == REQUEST_PICKER && resultCode == RESULT_OK){
            int pickedNumber = data.getIntExtra(getString(R.string.pickedNumber), 0);
            String text = getString(R.string.picker_text) + " " + pickedNumber;
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();

        }else if(requestCode == REQUEST_EDIT_TEXT && resultCode == RESULT_OK){
            EditTextInfo editTextInfo = (EditTextInfo) data.getSerializableExtra(getString(R.string.editText_info));
            String editText = editTextInfo.toString();
            Toast.makeText(context, editText, Toast.LENGTH_LONG).show();

        }else if(requestCode == REQUEST_SLIDE && resultCode == RESULT_OK){
            int red = data.getIntExtra(getString(R.string.slider_color_red),0);
            int green = data.getIntExtra(getString(R.string.slider_color_green),0);
            int blue = data.getIntExtra(getString(R.string.slider_color_blue),0);
            String text = "Red: " + red + "\n" + "Green: " + green + "\n" + "Blue: " + blue + "\n";
            LinearLayout layout = (LinearLayout) findViewById(R.id.main_layoutRoot);
            layout.setBackgroundColor(Color.rgb(red, green, blue));
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        }
    }
}
