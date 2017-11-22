package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userEmail;
    Button saveButton,nextButton;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String key = "address_shared_preferences";

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
        String emailAddress = userEmail.getText().toString();
        editor.putString(emailAddress,emailAddress);
        userEmail.setText("");
    }

    public void nextIntent(View view){
        Intent toRecycler = new Intent(this, RecyclerActivity.class);
        toRecycler.putExtra("sharedpref",key);
        startActivity(toRecycler);
    }
}
