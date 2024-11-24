package com.example.chittootech.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chittootech.MainActivity;
import com.example.chittootech.R;
import com.example.chittootech.Yourself;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CertificateFragment extends Fragment {


    private EditText answerEditText;
    private TextView countdownTimerText;
    private Button submitButton;
    private CountDownTimer countdownTimer;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_certificate, container, false);

        Button button=view.findViewById(R.id.btnWinCertificate);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Yourself.class);
                startActivity(intent);
            }
        });



      return view;
    }

    private void startCountdownTimer() {
        countdownTimer = new CountDownTimer(30000, 1000) {
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