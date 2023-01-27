package com.example.a06_intent; //

import androidx.appcompat.app.AppCompatActivity; //

import android.content.Intent; //
import android.os.Bundle; //
import android.view.View; //
import android.widget.Button; //
import android.widget.EditText; //
import android.widget.TextView; //

public class SecondActivity extends AppCompatActivity {

    private TextView questiontextView;
    private EditText answer_editText;
    private Button answer_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // obtain the reference
        questiontextView = (TextView) findViewById(R.id.questionTextView);
        answer_editText = (EditText) findViewById(R.id.answerEditText);
        answer_button = (Button) findViewById(R.id.answerButton);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            String question_str = extra.getString("question"); //

            questiontextView.setText(question_str);
        } //End of if

        //register
        ButtonHandler handler = new ButtonHandler();
        answer_button.setOnClickListener(handler);
    } //End of OnCreate

    public void finish(){
        Intent retIntent = new Intent();

        String answerStr = answer_editText.getText().toString();
        retIntent.putExtra("answer", answerStr);

        setResult(RESULT_OK, retIntent);
        super.finish();
    } //End of finish

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v) {
            finish();
        } //End of Onclick
    } //End of ButtonHandler
} // End of SecondActivity class