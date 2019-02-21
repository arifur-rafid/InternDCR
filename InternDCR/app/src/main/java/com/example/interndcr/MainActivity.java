package com.example.interndcr;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Json file link
    String URL="https://raw.githubusercontent.com/appinion-dev/intern-dcr-data/master/data.json";
    Spinner p_group,lit,phy_sample,gift;
    private RequestQueue mQueue;
    String p="";
    boolean pg_flag=true,l_flag=true,ps_flag=true,g_flag=true,flag=true;
    // After fetching data from json file, data will be in these list
    public static List<String> pg_data=new ArrayList<>();
    public static List<String> l_data=new ArrayList<>();
    public static List<String> ps_data=new ArrayList<>();
    public static List<String> gift_data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_group=(Spinner)findViewById(R.id.pgSpin);
        lit=(Spinner)findViewById(R.id.lSpin);
        phy_sample=(Spinner)findViewById(R.id.psSpin);
        gift=(Spinner)findViewById(R.id.gSpin);
        mQueue = Volley.newRequestQueue(this);
        all_Func_Declare();
    }

    void all_Func_Declare()
    {

        jsonParse();    //This function will fetch data and load that in list
        populate_Pg_Spinner();  // populate spinner with relevent data
        populate_L_Spinner();   // populate spinner with relevent data
        populate_Ps_Spinner();  // populate spinner with relevent data
        populate_Gift_Spinner();    // populate spinner with relevent data
        onClickSaveButtonListener();    // Save button listener
    }

    public void onClickSaveButtonListener(){
        Button save=(Button)findViewById(R.id.savebtn);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"done", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    void populate_Pg_Spinner()
    {
        ArrayAdapter<String>pg_adp=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,pg_data)
        {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.parseColor("#0097a7"));   // it adds color to the 0 index string-"Choose"
                }
                else {
                    tv.setTextColor(Color.BLACK);   // Main data will be in black color
                }
                return view;
            }
        };
        pg_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        p_group.setAdapter(pg_adp);

    }
    void populate_L_Spinner()
    {
        ArrayAdapter<String>l_adp=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,l_data)
        {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.parseColor("#0097a7"));   // it adds color to the 0 index string-"Choose"
                }
                else {
                    tv.setTextColor(Color.BLACK);   // Main data will be in black color
                }
                return view;
            }
        };
        l_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        lit.setAdapter(l_adp);
    }
    void populate_Ps_Spinner()
    {
        ArrayAdapter<String>ps_adp=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,ps_data)
        {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.parseColor("#0097a7"));   // it adds color to the 0 index string-"Choose"
                }
                else {
                    tv.setTextColor(Color.BLACK);   // Main data will be in black color
                }
                return view;
            }
        };
        ps_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        phy_sample.setAdapter(ps_adp);

    }
    void populate_Gift_Spinner()
    {
        ArrayAdapter<String>gift_adp=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,gift_data)
        {
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.parseColor("#0097a7"));   // it adds color to the 0 index string-"Choose"
                }
                else {
                    tv.setTextColor(Color.BLACK);   // Main data will be in black color
                }
                return view;
            }
        };
        gift_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        gift.setAdapter(gift_adp);
    }

    private void jsonParse(){
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray=response.getJSONArray("product_group_list");
                    JSONArray literature_list_Array=response.getJSONArray("literature_list");
                    JSONArray physician_sample_list_Array=response.getJSONArray("physician_sample_list");
                    JSONArray gift_list_Array=response.getJSONArray("gift_list");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject p_list=jsonArray.getJSONObject(i);
                        //int p_id= p_list.getInt("id");
                        String p_name=p_list.getString("product_group");
                        if(pg_data.size()<=jsonArray.length())
                        {
                            if(pg_flag)
                            {
                                pg_data.add("Choose");
                                pg_flag=false;
                            }
                            pg_data.add(p_name);
                        }
                    }

                    for(int i=0;i< literature_list_Array.length();i++)
                    {
                        JSONObject l_list= literature_list_Array.getJSONObject(i);
                        ///int l_id= l_list.getInt("id");
                        String l_name=l_list.getString("literature");
                        if(l_data.size()<=literature_list_Array.length())
                        {
                            if(l_flag)
                            {
                                l_data.add("Choose");
                                l_flag=false;
                            }
                            l_data.add(l_name);
                        }
                    }

                    for(int i=0;i< physician_sample_list_Array.length();i++)
                    {
                        JSONObject ps_list= physician_sample_list_Array.getJSONObject(i);
                       // int ps_id= ps_list.getInt("id");
                        String ps_name=ps_list.getString("sample");
                        if(ps_data.size()<=physician_sample_list_Array.length())
                        {
                            if(ps_flag)
                            {
                                ps_data.add("Choose");
                                ps_flag=false;
                            }
                            ps_data.add(ps_name);
                        }
                    }

                    for(int i=0;i< gift_list_Array.length();i++)
                    {
                        JSONObject gift_list= gift_list_Array.getJSONObject(i);
                        //int gift_id= gift_list.getInt("id");
                        String gift_name=gift_list.getString("gift");
                        if(gift_data.size()<=gift_list_Array.length())
                        {
                            if(g_flag)
                            {
                                gift_data.add("Choose");
                                g_flag=false;
                            }
                            gift_data.add(gift_name);
                        }
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

}
