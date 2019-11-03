package constantin.tuca.countingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private int global_number = 1;
    String level;
    private int number;
    private static final String TAG = "MainActivity";

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: in");
        setContentView(R.layout.activity_main);

        number = global_number;
        level = "Level " + String.valueOf(global_number);

        button = findViewById(R.id.button);

        textView = findViewById(R.id.textView);
        if(textView != null) {

            textView.setText(level);
        }


        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(String.valueOf(number));
                if(global_number == number) {
                    if(textView != null) {

                        textView.setText(level);
                    }
                }

                if(number != 1) {
                    number -= 1;
                } else {
                    number = global_number + 1;
                    global_number ++;
                    level = "Level " + String.valueOf(global_number);
                }
            }
        };

        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");

    }
}

