package com.example.chittootech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Yourself extends AppCompatActivity {

    private EditText answerEditText;
    private TextView countdownTimerText;
    private Button submitButton;
    private CountDownTimer countdownTimer;
    private TextView enteredAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourself);

        answerEditText =findViewById(R.id.answer_edit_text);
        countdownTimerText =findViewById(R.id.countdown_timer);
        submitButton = findViewById(R.id.submit_button);
        enteredAnswerText = findViewById(R.id.entered_answer_text);

        startCountdownTimer();

        submitButton.setOnClickListener(v -> {
            String userAnswer = answerEditText.getText().toString();
            enteredAnswerText.setText("Your answer: " + userAnswer);

        });
    }

    private void startCountdownTimer() {

        countdownTimer = new CountDownTimer(30000, 1000) {  // 30 seconds countdown
            @Override
            public void onTick(long millisUntilFinished) {
                countdownTimerText.setText("Time left: " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                answerEditText.setEnabled(false);
                submitButton.setEnabled(true);
                countdownTimerText.setText("Time's up!");
            }
        };
        countdownTimer.start();
    }
}