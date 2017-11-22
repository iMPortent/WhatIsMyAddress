package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.*;

/**
 * Created by MarckemX on 11/21/17.
 */

public class RecyclerActivity extends AppCompatActivity {
    Map<String, ?> myMap= new HashMap<>();
    ArrayList<Object>addresses = new ArrayList<>();
    RecyclerView recyclerView;
    String intentsKey = "fromRecycler";
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);


        Intent intent = getIntent();
        String key = getIntent().getExtras().getString(Intent.EXTRA_TEXT);
        preferences = getSharedPreferences(key,MODE_PRIVATE);

       myMap = preferences.getAll();
       for(String x : myMap.keySet()){
           addresses.add(myMap.get(x));
       }

       recyclerView = findViewById(R.id.recycler_holder);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        MyAdapter adapter = new MyAdapter(addresses);
        recyclerView.setAdapter(adapter);

    }

    public void takeToDisplay(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(intent.EXTRA_TEXT,((TextView) view).getText());
        startActivity(intent);
    }

}
