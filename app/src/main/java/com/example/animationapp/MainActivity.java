package com.example.animationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    EditText name,address,password,about;
    Button create;
    TextView status;
    LottieAnimationView animationView;
    LinearLayout loadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameET);
        address = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordET);
        about = findViewById(R.id.aboutET);
        create = findViewById(R.id.createBTN);
        status = findViewById(R.id.statusTV);
        animationView = findViewById(R.id.animation_view);
        loadingView = findViewById(R.id.loadingLayout);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().length() == 0){
                    name.setError("Name is required.");
                    return;
                }else if(address.getText().length() == 0){
                    address.setError("Email is required.");
                    return;
                }else if(password.getText().length() == 0){
                    password.setError("Email is required.");
                    return;
                }else if(about.getText().length() == 0){
                    about.setError("Email is required.");
                    return;
                }
                loadingView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                status.setText("Creating new Account..");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animationView.setAnimation(R.raw.success);
                        animationView.playAnimation();
                        animationView.setRepeatCount(0);
                        status.setText("User Created Successfully");
                    }
                },3000);
            }
        });

    }
}