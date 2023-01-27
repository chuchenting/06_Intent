package com.example.a06_intent; //

import androidx.appcompat.app.AppCompatActivity; //

import android.annotation.SuppressLint;
import android.content.Intent; //
import android.os.Bundle; //
import android.view.View; //
import android.widget.Button; //
import android.widget.EditText; //
import android.widget.TextView; //

public class MainActivity extends AppCompatActivity {

    private static final int myRequest_Code = 1;
    private EditText questionMainEditText;
    private TextView answerTextView;
    private Button askButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionMainEditText = (EditText) findViewById(R.id.questionMainEditText);
        answerTextView = (TextView) findViewById(R.id.answerTextView);
        askButton = (Button) findViewById(R.id.askButton);

        ButtonHandler handler = new ButtonHandler();
        askButton.setOnClickListener(handler);
    }//End of OnCreate

    protected void onActivityResult(int request_code, int result_code, Intent data){
        super.onActivityResult(request_code, result_code, data);

        if(result_code == RESULT_OK && request_code == myRequest_Code){
            Bundle extra = data.getExtras();
            String answerStr = extra.getString("answer");
            if(answerStr != ""){
                answerTextView.setText(answerStr);
            }// End of if
        }// End of if
    }// End of onActivityResult

    public class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            Intent intent = new Intent (MainActivity.this, SecondActivity.class);
            String questionStr = questionMainEditText.getText().toString();
            intent.putExtra("question", questionStr);

            startActivityForResult(intent, myRequest_Code);
        } // End of onClick
    } //End of ButtonHandler




}// End of MainActivity