package com.hjd.gujaratiaccendingorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private StudentAdapter studentAdapter;
    private Button btnSort;
    ArrayList<String> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        words = new ArrayList<>();
        words.add("કાનજી");
        words.add("રમેશ");
        words.add("પ્રજ્ઞા");
        words.add("તુષાર");
        words.add("સુરેશ");
        words.add("ઈશાન");

        listView = (ListView) findViewById(R.id.list_item_tem_designer_new);

        Collator collator = Collator.getInstance(Locale.ENGLISH);
        Collections.sort(words, collator);

        for(String tmp : words){
            Log.i("INFO",""+tmp);
        }
        studentAdapter = new StudentAdapter(this, words);
        listView.setAdapter(studentAdapter);

        btnSort = (Button) findViewById(R.id.btnSort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.reverse(words);
                studentAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
