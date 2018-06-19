package com.example.ahmed.storyprophets;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    public void img_share(View view) {
        String txtShare = "قصص الانبياء";
        String link = "https://github.com/ahmedmhhh/StoryProphets";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT,txtShare+"\n"+link);
        startActivity(intent);
    }

    public void img_more(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/ahmedmhhh"));
        startActivity(intent);
    }

    public void img_email(View view) {
        try {
            String txt = "Hi Ahmed !";
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"a7medmhhh@hotmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "قصص الانبياء");
            i.putExtra(Intent.EXTRA_TEXT   , txt);
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this,"don't have mail application",Toast.LENGTH_LONG).show();
        }

    }

    public void img_exit(View view) {
        this.finish();
    }
}
