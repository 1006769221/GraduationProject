package com.example.administrator.v1.view;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.v1.Base.SharePerferencesUtils;
import com.example.administrator.v1.R;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button login;
    CheckBox rememberPass, autoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharePerferencesUtils.init(this);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        rememberPass = findViewById(R.id.rememberPass);
        autoLogin = findViewById(R.id.autoLogin);

        final String user1 = SharePerferencesUtils.getString("user");
        final String pass1 = SharePerferencesUtils.getString("pass");
        Boolean remember = SharePerferencesUtils.getBoolean("rememberPass");
        final Boolean auto = SharePerferencesUtils.getBoolean("autoLogin");

        if (!user1.equals("")) {
            user.setText(user1);
            pass.setText(pass1);
            rememberPass.setChecked(remember);
            autoLogin.setChecked(auto);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rememberPass.isChecked()) {
                    SharePerferencesUtils.put("user", user.getText().toString());
                    SharePerferencesUtils.put("pass", pass.getText().toString());
                    SharePerferencesUtils.put("rememberPass", true);
                } else {
                    SharePerferencesUtils.put("pass","");
                    SharePerferencesUtils.put("rememberPass", false);
                }
                if (autoLogin.isChecked()) {
                    SharePerferencesUtils.put("autoLogin", true);
                } else {
                    SharePerferencesUtils.put("autoLogin", false);
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"登录成功！", Toast.LENGTH_SHORT).show();
            }

        });
        if (autoLogin.isChecked() && !user1.equals("") && !pass1.equals("")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

    }
}
