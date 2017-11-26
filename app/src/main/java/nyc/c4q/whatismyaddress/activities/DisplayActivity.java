package nyc.c4q.whatismyaddress.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.whatismyaddress.EmailAddress;
import nyc.c4q.whatismyaddress.R;

/**
 * Created by MarckemX on 11/21/17.
 */

public class DisplayActivity extends AppCompatActivity{

    String email;
    TextView theEmail,dateTime;
    Button back,deleteButton;
    SharedPreferences preferences ;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_layout);

        theEmail = findViewById(R.id.the_email);
        dateTime = findViewById(R.id.created_time);
        deleteButton = findViewById(R.id.delete_email);

        preferences = getSharedPreferences(MainActivity.key,MODE_PRIVATE);
        editor = preferences.edit();

        email = getIntent().getExtras().getString(Intent.EXTRA_TEXT);

        theEmail.setText(email);


    }

    public void delete(View view){
        editor.remove(email);
        editor.commit();
        if(preferences.getAll().size()==0){
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "No more addresses saved!",Toast.LENGTH_LONG);
            startActivity(intent);

        } else {
            Intent intent = new Intent(this, RecyclerActivity.class);
            startActivity(intent);
        }

    }

    public void dontDelete(View view){
        Intent intent = new Intent(this, RecyclerActivity.class);
        startActivity(intent);
    }

}
