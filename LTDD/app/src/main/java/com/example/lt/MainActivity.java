package com.example.lt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButtonTrue;
    private Button mButtonFalse;
    private Button mButtonNext;
    private TextView mtext_view_question;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.Text_cauhoi1,true),
            new Question(R.string.Text_cauhoi2,false),
            new Question(R.string.Text_cauhoi3,false),
            new Question(R.string.Text_cauhoi4,false)
    };

    private int mCurrentIndex =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtext_view_question = findViewById(R.id.text_view_question);
        mButtonNext = findViewById(R.id.buttonNext);
        mButtonTrue = findViewById(R.id.buttonTrue);
        mButtonFalse = findViewById(R.id.buttonFalse);
        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionBank[mCurrentIndex].ismAnswerTrue())
                {
                    Toast.makeText(MainActivity.this,"Dúng", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"sai", Toast.LENGTH_SHORT).show();
            }

        });
        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionBank[mCurrentIndex].ismAnswerTrue())
                {
                    Toast.makeText(MainActivity.this,"Sai", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Đúng", Toast.LENGTH_SHORT).show();
            }

        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;
                mtext_view_question.setText(mQuestionBank[mCurrentIndex].getmTextResId());
            }
        });
        mtext_view_question.setText(mQuestionBank[mCurrentIndex].getmTextResId());
    }


}