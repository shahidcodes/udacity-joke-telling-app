package ml.shahidkamal.libjokerui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class JokerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);
        Intent intent = getIntent();
        if(intent!=null) {
            String joke = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView textView = findViewById(R.id.textview_joke);
            textView.setText(joke);
        }else{
            Toast.makeText(this, "Need a joke bro!", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
