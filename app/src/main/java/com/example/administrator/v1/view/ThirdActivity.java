package com.example.administrator.v1.view;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.v1.Base.BasicAdapter;
import com.example.administrator.v1.Base.recharge;
import com.example.administrator.v1.R;

import java.util.List;

public class ThirdActivity extends AppCompatActivity implements recharge, View.OnClickListener {

    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        recyclerView = findViewById(R.id.dataRec);
        recyclerView.setHasFixedSize(false);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = 5;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BasicAdapter a = new BasicAdapter(this);
        recyclerView.setAdapter(a);
    }
    AlertDialog.Builder dialog;
    public void showDialog() {
         dialog = new AlertDialog.Builder(ThirdActivity.this);
        final View dialogView = LayoutInflater.from(ThirdActivity.this).inflate(R.layout.dialog, null);

        dialog.setPositiveButton("充值", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(ThirdActivity.this,"充值成功",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.setView(dialogView);
        dialog.show();
    }

    @Override
    public void clickCharge() {
        showDialog();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            default:
                break;
        }
    }
}
