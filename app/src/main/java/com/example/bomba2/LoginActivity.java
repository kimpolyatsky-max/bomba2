package com.example.bomba2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameInput = findViewById(R.id.etUser);
        EditText passwordInput = findViewById(R.id.etPass);
        Button loginButton = findViewById(R.id.btnLogin);
        CheckBox rememberMeCheckbox = findViewById(R.id.cbRememberMe);
        TextView registerLink = findViewById(R.id.tvToRegister);

        String registeredUsername = getIntent().getStringExtra("username");
        String registeredPassword = getIntent().getStringExtra("password");
        if (registeredUsername != null) {
            usernameInput.setText(registeredUsername);
        }

        loginButton.setOnClickListener(view -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "יש למלא את כל השדות", Toast.LENGTH_SHORT).show();
            } else if (registeredUsername == null || registeredPassword == null) {
                Toast.makeText(this, "יש להירשם קודם", Toast.LENGTH_SHORT).show();
            } else if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                String rememberStatus = rememberMeCheckbox.isChecked()
                        ? "תיבת זכור אותי מסומנת"
                        : "תיבת זכור אותי לא מסומנת";
                Toast.makeText(this, rememberStatus, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "שם המשתמש או הסיסמה שגויים", Toast.LENGTH_SHORT).show();
            }
        });

        registerLink.setOnClickListener(view ->
                startActivity(new Intent(this, RegisterActivity.class)));
    }
}
