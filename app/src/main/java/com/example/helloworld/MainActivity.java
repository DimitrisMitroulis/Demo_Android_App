package com.example.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //general tips
    //Every view must have at least one horizontal and one vertica constraint.
    //A vertical constraint can be constrained only to another vertical pane.(You can't constrain a left to top)
    // Each constraint handle can be used to attach only one constraint,but you can create multiple constraints(from diff. widgets)
    // to the same anchor point.
    //Tip: constrain all the elements that you want to stick together to the same side(left/right wall)


    private EditText userInput;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.winButton);
        textView = (TextView) findViewById(R.id.textView);


    }

}
