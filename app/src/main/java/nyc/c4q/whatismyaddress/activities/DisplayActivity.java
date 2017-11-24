package nyc.c4q.whatismyaddress.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nyc.c4q.whatismyaddress.EmailAddress;
import nyc.c4q.whatismyaddress.R;

/**
 * Created by MarckemX on 11/21/17.
 */

public class DisplayActivity extends AppCompatActivity{

    String email;
    TextView theEmail,dateTime;
    Button deleteButton;
    EmailAddress thisAddress;
    String key;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_layout);

        key = MainActivity.key;
        preferences = getSharedPreferences(key,MODE_PRIVATE);
        editor = preferences.edit();

        theEmail = findViewById(R.id.the_email);
        dateTime = findViewById(R.id.created_time);
        deleteButton = findViewById(R.id.delete_email);

        email = getIntent().getExtras().getString(Intent.EXTRA_TEXT);

        theEmail.setText(email);
        findClass();




    }

    public void delete(View view){
        editor.remove(thisAddress.getKey());
        Intent intent = new Intent(this, RecyclerActivity.class);
        editor.commit();
        startActivity(intent);

    }

    public void findClass(){
        for(int i = 0; i < MainActivity.allAddys.size();i++){
            thisAddress = MainActivity.allAddys.get(i);
            if(email==thisAddress.getTheAddress()){
                dateTime.setText(String.valueOf(thisAddress.getTimeCreated()));
            }
        }
    }

}
