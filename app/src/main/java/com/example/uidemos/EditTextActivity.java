package com.example.uidemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }

    public void okButtonPressed(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditTextInfo textInfo = new EditTextInfo(this);
        intent.putExtra(getString(R.string.editText_info),textInfo);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelButtonPressed(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
