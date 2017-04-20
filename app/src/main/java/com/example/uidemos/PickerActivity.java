package com.example.uidemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class PickerActivity extends AppCompatActivity {
    private NumberPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        picker = (NumberPicker) findViewById(R.id.numberPicker);
        picker.setMaxValue(1000);
        picker.setMinValue(0);
    }

    public void okButtonPressed(View view){
        Intent intent = new Intent(this, MainActivity.class);
        int pickedNumber = picker.getValue();
        intent.putExtra(getString(R.string.pickedNumber), pickedNumber);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelButtonPressed(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
