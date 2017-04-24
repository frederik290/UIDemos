package com.example.uidemos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_PICKER = 1;
    public static final int REQUEST_EDIT_TEXT = 2;
    public static final int REQUEST_SLIDE = 3;
    public static final String INTENT_PICKER = "com.example.uidemos.intent.action.PICKER";
    public static final String INTENT_EDIT_TEXT = "com.example.uidemos.intent.action.EDIT_TEXT";
    public static final String INTENT_SLIDE = "com.example.uidemos.intent.action.SLIDE";
    private ArrayList<DemoData> demoDataList;
    private ArrayAdapter<DemoData> adapter;

    private OnItemClickListener listItemClickedHandler = new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            DemoData dataItem = demoDataList.get(position);
            String action = dataItem.getAction();
            Intent intent = new Intent();
            intent.setAction(action);

            if(intent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(intent, dataItem.getRequestCode());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bootstrapDemoDataList();
        adapter = new ArrayAdapter<>(this, R.layout.list_view_item, demoDataList);
        ListView listView = (ListView) findViewById(R.id.myListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listItemClickedHandler);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.search:
                SearchDialog searchDialog = new SearchDialog();
                searchDialog.show(getFragmentManager(), null);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void bootstrapDemoDataList(){
        DemoData d1 = new DemoData("Picker Demo", INTENT_PICKER, REQUEST_PICKER);
        DemoData d2 = new DemoData("EditText Demo", INTENT_EDIT_TEXT, REQUEST_EDIT_TEXT);
        DemoData d3 = new DemoData("Slider Demo", INTENT_SLIDE, REQUEST_SLIDE);
        demoDataList = new ArrayList<>();
        demoDataList.add(d1);
        demoDataList.add(d2);
        demoDataList.add(d3);
    }



}
