package nyc.c4q.whatismyaddress.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(key,MODE_PRIVATE);
        editor = preferences.edit();


        userEmail = findViewById(R.id.email_field);
        saveButton = findViewById(R.id.save_button);
        nextButton = findViewById(R.id.next_button);
    }

    public void saveEmailAdd(View view){
        EmailAddress emailAddress = new EmailAddress(userEmail.getText().toString());
        allAddys.add(emailAddress);
        editor.putString(emailAddress.getKey(),emailAddress.getKey());
        userEmail.setText("");
    }

    public void nextIntent(View view){
        Intent toRecycler = new Intent(this, RecyclerActivity.class);
        toRecycler.putExtra("sharedpref",key);
        editor.commit();
        startActivity(toRecycler);
    }

    public void takeToDisplay(View view) {
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(intentsKey,((TextView) view).getText());
        startActivity(intent);
    }
}
