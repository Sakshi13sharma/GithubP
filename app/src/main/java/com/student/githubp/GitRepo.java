package com.student.githubp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GitRepo extends AppCompatActivity implements Responsedata {

    ListView repo_list;
    String url="https://api.github.com/users/";
    Context ctx=this;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_repo);
        msg=(TextView)findViewById(R.id.msg);
        getSupportActionBar().setTitle("Repositories");
        repo_list=(ListView)findViewById(R.id.repo_list);
        String username=getIntent().getExtras().getString("username");
        url=url+username+"/repos";
        GetJson.getdata(this,url,this);
    }

    @Override
    public void processFinish(String output) {


        ContactAdapter   contactAdapter=new ContactAdapter(ctx,R.layout.listitems);
        try {
            JSONArray jsonArray = new JSONArray(output);
            int count=0;
            int k=0;
            if(jsonArray.length()==0){
                msg.setText("You don't have any repositories");
                msg.setVisibility(View.VISIBLE);
                repo_list.setVisibility(View.GONE);
            }
            while (count<jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(count);
                String name=jo.getString("name");
                Contacts contacts = new Contacts("http://pngimg.com/uploads/folder/folder_PNG8773.png",name);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        repo_list.setAdapter(contactAdapter);
    }
}
