package com.example.uidemos;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class SlideActivity extends AppCompatActivity {
    private int red;
    private int green;
    private int blue;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        layout = (LinearLayout) findViewById(R.id.slider_layoutRood);
        red = green = blue = 0;
        initSeekBarValues();
        updateBackgroundColor();
    }

    private void initSeekBarValues(){
        SeekBar redBar = (SeekBar) findViewById(R.id.seekBar_red);
        SeekBar greenBar = (SeekBar) findViewById(R.id.seekBar_green);
        SeekBar blueBar = (SeekBar) findViewById(R.id.seekBar_blue);

        redBar.setMax(255);
        greenBar.setMax(255);
        blueBar.setMax(255);

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                updateBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                updateBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                updateBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });
    }

    private void updateBackgroundColor(){
        layout.setBackgroundColor(Color.rgb(red, green, blue));
    }

    public void okButtonPressed(View view){
        Intent intent = new Intent();
        intent.putExtra(getString(R.string.slider_color_red),red);
        intent.putExtra(getString(R.string.slider_color_green),green);
        intent.putExtra(getString(R.string.slider_color_blue),blue);
        setResult(RESULT_OK, intent);
        finish();
    }


    public void cancelButtonPressed(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
