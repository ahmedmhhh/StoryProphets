package com.example.ahmed.storyprophets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);

        String [] items = getResources().getStringArray(R.array.index);

        ArrayAdapter arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.new_row, R.id.testName,items);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,WebStory.class);
                intent.putExtra("page",position);
                startActivity(intent);
            }
        });
    }
}
