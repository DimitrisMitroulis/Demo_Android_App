package com.example.helloworld;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //general tips
    //Every view must have at least one horizontal and one vertica constraint.
    //A vertical constraint can be constrained only to another vertical pane.(You can't constrain a left to top)
    // Each constraint handle can be used to attach only one constraint,but you can create multiple constraints(from diff. widgets)
    // to the same anchor point.
    //Tip: constrain all the elements that you want to stick together to the same side(left/right wall)
    //Only editable widgets (editText) get their state saved when the phone turns orientation
    //LAst course: 24


    private EditText userInput;
    private Button button;
    private TextView textView;
    private int TimesClicked = 0;
    private final String SavedTimesCLicked = "";
    private final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "";

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestore: in");
        super.onRestoreInstanceState(savedInstanceState);
        //String savedString = savedInstanceState.getString(TEXT_CONTENTS);//extraction of data must be happening after super
        textView.append(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestore: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSave: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString()); // saving must be happening before super is called
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSave: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }



    @Override//On create method is called when the app is started,bundle is null so nothing needs to be restored
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        
        super.onCreate(savedInstanceState);// to save the states when changing orientation
        setContentView(R.layout.third_layout);

        userInput = findViewById(R.id.editText);
        button = findViewById(R.id.winButton);
        textView = findViewById(R.id.textView);

        textView.setMovementMethod(new ScrollingMovementMethod());
        mainVoid();
        Log.d(TAG, "onCreate: out");



    }


    private void mainVoid() {

        View.OnClickListener winButtonListener = view -> {

            if (!String.valueOf(userInput.getText()).equals("")) {
                TimesClicked += 1;
                Log.d(TAG, String.valueOf(TimesClicked));

                //textView.append("\n" + String.valueOf(userInput.getText()));
                if (TimesClicked == 1 ) {
                    textView.append(String.valueOf(userInput.getText())+"\n");
                }else {
                    textView.append(userInput.getText()+"\n");
                }

                userInput.setText(""); //clear text
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Please write something", Toast.LENGTH_SHORT);
                toast.show();

            }
        };

        button.setOnClickListener(winButtonListener);
        
    }


}
