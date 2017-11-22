package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by MarckemX on 11/21/17.
 */

public class DisplayActivity extends AppCompatActivity{

    TextView theEmail, emailSize;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_layout);

        theEmail = findViewById(R.id.the_email);
        emailSize = findViewById(R.id.the_email_size);

        String x = getIntent().getExtras().getString(Intent.EXTRA_TEXT);

        theEmail.setText(x);
        emailSize.setText(String.valueOf(x.length()));


    }
}
