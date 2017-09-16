package com.student.githubp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Followers extends AppCompatActivity implements Responsedata{

    Context ctx=this;
    ListView follower_list;
    String url = "https://api.github.com/users/";
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);
        msg=(TextView)findViewById(R.id.msg);
        getSupportActionBar().setTitle("Followers");
        String username=getIntent().getExtras().getString("username");
        url=url+username+"/followers";
        GetJson.getdata(this,url,this);
        follower_list=(ListView)findViewById(R.id.follower_list);
    }

    @Override
    public void processFinish(String output) {
        ContactAdapter   contactAdapter=new ContactAdapter(ctx,R.layout.listitems);
        try {
            JSONArray jsonArray = new JSONArray(output);
            int count=0;
            int k=0;
            if(jsonArray.length()==0){
                msg.setText("You don't have any followers");
                msg.setVisibility(View.VISIBLE);
                follower_list.setVisibility(View.GONE);
            }
            while (count<jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(count);
                String name=jo.getString("login");
                String img=jo.getString("avatar_url");
                    Contacts contacts = new Contacts(img,name);
                    contactAdapter.add(contacts);


                count++;
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        follower_list.setAdapter(contactAdapter);

    }
}
