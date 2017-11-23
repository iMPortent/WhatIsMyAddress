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
    String intentsKey = MainActivity.intentsKey;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        preferences = getSharedPreferences(MainActivity.key,MODE_PRIVATE);


        recyclerView = findViewById(R.id.recycler_holder);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        loadList();

        MyAdapter adapter = new MyAdapter(addresses);
        recyclerView.setAdapter(adapter);

    }

//    public void takeToDisplay(View view){
//        Intent intent = new Intent(this, DisplayActivity.class);
//        intent.putExtra(intent.EXTRA_TEXT,((TextView) view).getText());
//        startActivity(intent);
//    }

    public void loadList(){
        myMap = preferences.getAll();
        for(String x : myMap.keySet()){
            addresses.add(myMap.get(x));
        }

    }

}
