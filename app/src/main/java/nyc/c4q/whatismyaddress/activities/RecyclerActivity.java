package nyc.c4q.whatismyaddress.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;

import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.controller.MyAdapter;

/**
 * Created by MarckemX on 11/21/17.
 */

public class RecyclerActivity extends AppCompatActivity {
    Map<String, ?> myMap;
    ArrayList<Object>addresses;
    RecyclerView recyclerView;
    SharedPreferences preferences;
    Button addMore;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        setValues();
        createRecyclerView();

    }

    public void setValues() {
        addMore = findViewById(R.id.add_more);
        myMap = new HashMap<>();
        addresses = new ArrayList<>();
        preferences = getSharedPreferences(MainActivity.key,MODE_PRIVATE);
    }

    public void loadList(){
        myMap = preferences.getAll();
        for(String x : myMap.keySet()){
            addresses.add(myMap.get(x));
        }

    }

    public void createRecyclerView(){
        recyclerView = findViewById(R.id.recycler_holder);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        loadList();

        MyAdapter adapter = new MyAdapter(addresses);
        recyclerView.setAdapter(adapter);
    }

    public void takeToDisplay(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        String selected = ((TextView) view ).getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT,selected);
        startActivity(intent);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
