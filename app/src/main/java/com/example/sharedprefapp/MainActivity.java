package com.example.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        e1 = findViewById(R.id.editTextTextPersonName);
        e2 = findViewById(R.id.editTextTextPersonName2);
    }

    public void login(View view) {
        String name = e1.getText().toString();
        String password = e2.getText().toString();
        SharedPreferences sp = getSharedPreferences("ABC", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name",name);
        editor.putString("password",password);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Saved Content",Toast.LENGTH_SHORT).show();
    }

    public void show(View view) {
        SharedPreferences sp = getSharedPreferences("ABC", Context.MODE_PRIVATE);
        String s1 = sp.getString("name","");
        String s2 = sp.getString("password","");
        e1.setText(s1);
        e2.setText(s2);
        Toast.makeText(getApplicationContext(), "Content Auto Filled ", Toast.LENGTH_SHORT).show();
    }
}