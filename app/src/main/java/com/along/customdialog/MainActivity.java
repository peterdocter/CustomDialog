package com.along.customdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        //弹出一个对话框
        if (dialog == null) {
            dialog = new CustomDialog(MainActivity.this);
            view = View.inflate(getApplicationContext(), R.layout.dialog_show, null);
            dialog.setContentView(view);
            TextView start = (TextView) view.findViewById(R.id.start);
            TextView edit = (TextView) view.findViewById(R.id.edit);
            TextView cancle = (TextView) view.findViewById(R.id.cancle);
            start.setOnClickListener(this);
            edit.setOnClickListener(this);
            cancle.setOnClickListener(this);
        }
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(getApplicationContext(), "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancle:
                dialog.dismiss();
                break;
        }
    }
}
