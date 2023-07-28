package com.example.singleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView statusTextView;
    private Button loginButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);
        loginButton = findViewById(R.id.loginButton);
        logoutButton = findViewById(R.id.logoutButton);
        updateUI();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManager.getInstance().setLoggedIn(true);
                UserManager.getInstance().setUsername("Madhu");
                updateUI();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManager.getInstance().setLoggedIn(false);
                UserManager.getInstance().setUsername("");
                updateUI();
            }
        });
    }

    private void updateUI() {
        if (UserManager.getInstance().isLoggedIn()) {
            statusTextView.setText("Logged in as " + UserManager.getInstance().getUsername());
            loginButton.setEnabled(false);
            logoutButton.setEnabled(true);
        } else {
            statusTextView.setText("Current Status: Not logged in");
            loginButton.setEnabled(true);
            logoutButton.setEnabled(false);
        }
    }
}