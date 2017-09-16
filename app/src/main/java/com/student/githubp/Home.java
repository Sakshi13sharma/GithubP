package com.student.githubp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    ListView menulist;
    String username;
    Button repositories,stars,followers,following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        repositories=(Button) findViewById(R.id.repositories);
        stars=(Button) findViewById(R.id.stars);
        followers=(Button) findViewById(R.id.followers);
        following=(Button) findViewById(R.id.following);
        getSupportActionBar().setTitle("Home");
        final String username=getIntent().getExtras().getString("username");
        repositories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GitRepo.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Started.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Followers.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Following.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
}
