package nyc.c4q.whatismyaddress.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nyc.c4q.whatismyaddress.EmailAddress;
import nyc.c4q.whatismyaddress.R;

public class MainActivity extends AppCompatActivity {
    public static EditText userEmail;
    public static Button saveButton,nextButton;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    public static String key = "address_shared_preferences";
    public static String intentsKey = "fromRecycler";
    public static ArrayList<EmailAddress>allAddys = new ArrayList<>();
    public static Map<String, ?>myMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(key,MODE_PRIVATE);
        editor = preferences.edit();


        userEmail = findViewById(R.id.email_field);
        saveButton = findViewById(R.id.save_button);
        nextButton = findViewById(R.id.next_button);

        loadList();

    }

    public void loadList(){
        myMap = preferences.getAll();
        for(String x : myMap.keySet()){
            String[] splitStr = x.split(",");
            allAddys.add(new EmailAddress(splitStr[0]));
        }

    }

    public void saveEmailAdd(View view){
        String emailAddress = userEmail.getText().toString();
        editor.putString(emailAddress, emailAddress);
        userEmail.setText("");
        editor.commit();
    }

    public void nextIntent(View view) {
        if(!(preferences.getAll().size()==0)){
            Intent toRecycler = new Intent(this, RecyclerActivity.class);
            toRecycler.putExtra("sharedpref", key);
            //editor.commit();
            startActivity(toRecycler);
        } else {
            Toast.makeText(this, "No addresses saved!",Toast.LENGTH_LONG).show();
        }
    }

    public void takeToDisplay(View view) {
        if(!(preferences.getAll().size()==0)) {
            Intent intent = new Intent(this, DisplayActivity.class);
            intent.putExtra(intentsKey, ((TextView) view).getText());
            startActivity(intent);
        } else {
            Toast.makeText(this, "There are no email addresses stored!", Toast.LENGTH_SHORT).show();
        }
    }
}
