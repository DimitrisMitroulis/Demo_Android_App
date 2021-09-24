package com.example.helloworld;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //general tips
    //Every view must have at least one horizontal and one vertica constraint.
    //A vertical constraint can be constrained only to another vertical pane.(You can't constrain a left to top)
    // Each constraint handle can be used to attach only one constraint,but you can create multiple constraints(from diff. widgets)
    // to the same anchor point.
    //Tip: constrain all the elements that you want to stick together to the same side(left/right wall)
    //Only editable widgets (editText) get their state saved when the phone turns orientation


    private EditText userInput;
    private Button button;
    private TextView textView;
    private int TimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate: in");
        super.onCreate(savedInstanceState);// to save the states when changing orientation
        setContentView(R.layout.third_layout);

        userInput = findViewById(R.id.editText);
        button = findViewById(R.id.winButton);
        textView = findViewById(R.id.textView);

        textView.setMovementMethod(new ScrollingMovementMethod());
        mainVoid();


    }
    @Override
    protected void onStart(){
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");

    }

    private void mainVoid() {

        View.OnClickListener winButtonListener = view -> {

            if (!String.valueOf(userInput.getText()).equals("")) {
                TimesClicked += 1;
                textView.append("\n" + userInput.getText());
                //textView.append("\n" + String.valueOf(userInput.getText()));
                if (TimesClicked == 1)
                    textView.setText(String.valueOf(userInput.getText()));

                userInput.setText(""); //clear text
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Please write something", Toast.LENGTH_SHORT);
                toast.show();

            }
        };

        button.setOnClickListener(winButtonListener);
    }


}
