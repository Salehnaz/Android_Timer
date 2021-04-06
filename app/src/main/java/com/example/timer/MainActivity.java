package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    Button button,Ebtn;
    TextView textView;
    EditText editText;
    long value,k,kk=1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        Ebtn=(Button) findViewById(R.id.Etext_btn_id);
        editText=(EditText) findViewById(R.id.Edit_text_id);
        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);

        Ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value = Integer.parseInt(editText.getText().toString());
                k=kk*value;

            }
        });



        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(k, 1000){
                    public void onTick(long millisUntilFinished){
                        textView.setText(String.valueOf(counter));
                        counter++;
                        button.setEnabled(false);

                    }
                    public  void onFinish(){
                        textView.setText("FINISH!!");
                        counter =0;
                        button.setEnabled(true);
                    }
                }.start();
            }
        });
    }
}