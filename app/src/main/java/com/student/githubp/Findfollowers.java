package com.student.githubp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Findfollowers extends AppCompatActivity {

    EditText et_username;
    Button bt_find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findfollowers);
        et_username=(EditText)findViewById(R.id.et_username);
        bt_find=(Button)findViewById(R.id.bt_find);
        bt_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_username.getText().toString().equals("")) {
                    et_username.setError("Username can't blank");
                    et_username.requestFocus();

                } else {
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    intent.putExtra("username", et_username.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

}
