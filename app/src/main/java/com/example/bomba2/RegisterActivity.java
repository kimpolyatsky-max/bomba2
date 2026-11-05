package com.example.bomba2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText usernameInput = findViewById(R.id.etRegUser);
        EditText passwordInput = findViewById(R.id.etRegPass);
        EditText confirmInput = findViewById(R.id.etRegConfirm);
        Button registerButton = findViewById(R.id.btnRegister);

        registerButton.setOnClickListener(view -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString();
            String confirmation = confirmInput.getText().toString();

            if (username.isEmpty()) {
                usernameInput.setError("יש להזין שם משתמש");
                return;
            }
            if (password.length() < 6) {
                passwordInput.setError("הסיסמה חייבת להכיל לפחות 6 תווים");
                return;
            }
            if (!password.equals(confirmation)) {
                confirmInput.setError("הסיסמאות אינן תואמות");
                return;
            }

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent);
            finish();
        });
    }
}
