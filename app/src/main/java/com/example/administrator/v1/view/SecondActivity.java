package com.example.administrator.v1.view;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.v1.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView openMenu;

    DrawerLayout mdrawer;



    LinearLayout nav_user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        openMenu = findViewById(R.id.openMenu);
        mdrawer = findViewById(R.id.mdrawer);

        nav_user = findViewById(R.id.nav_user);
        openMenu.setOnClickListener(this);

        nav_user.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.openMenu:
                mdrawer.openDrawer(Gravity.START);
                break;
            case R.id.nav_user:
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
