package sg.edu.rp.dmsd.radiogroupdemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    Button b1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = findViewById(R.id.rg1);
        tv1 = findViewById(R.id.textView);
        b1 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton bb = findViewById(rg1.getCheckedRadioButtonId());
                tv1.setText(bb.getText().toString() + " is selected");
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("gender", rg1.getCheckedRadioButtonId());
                prefEdit.putString("text", tv1.getText().toString());
                prefEdit.commit();

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        rg1.check(prefs.getInt("gender", 0));
        tv1.setText(prefs.getString("text", ""));
    }
}
