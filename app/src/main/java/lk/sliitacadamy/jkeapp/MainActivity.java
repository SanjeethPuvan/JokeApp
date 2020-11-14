package lk.sliitacadamy.jkeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
RequestQueue queue;
    String url ="https://official-joke-api.appspot.com/random_joke";
    TextView txtJokes,txtid,txttype,txtsetup,txtpunch;
   // private Object JsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue=Volley.newRequestQueue(this);
        txtJokes=findViewById(R.id.txtJokes);
        txtid=findViewById(R.id.txtid);
        txttype=findViewById(R.id.txttype);
        txtsetup=findViewById(R.id.txtsetup);
        txtpunch=findViewById(R.id.txtpunch);
    }


    public void getJokes(View view) {
        JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                int ID=0;
                String setup="",type="",punch="";
                try {
                    ID=response.getInt("id");
                    type=response.getString("type");
                    setup=response.getString("setup");
                    punch=response.getString("punchline");
                    txtid.setText("ID:"+ID);
                    txtid.setVisibility(View.VISIBLE);
                    txttype.setText("Type:"+type);
                    txttype.setVisibility(View.VISIBLE);
                    txtsetup.setText("Setup:"+setup);
                    txtsetup.setVisibility(View.VISIBLE);
                    txtpunch.setText("PunchLine:"+punch);
                    txtpunch.setVisibility(View.VISIBLE);
                    Joke jo=new Joke(ID,type,setup,punch);
                 /*   txtid.setText(jo.getId()+"");
                    txtid.setVisibility(View.VISIBLE);
                    txttype.setText(jo.getType()+"");
                    txttype.setVisibility(View.VISIBLE);
                    txtsetup.setText(jo.getSetup()+"");
                    txtsetup.setVisibility(View.VISIBLE);
                    txtpunch.setText(jo.getPunchLine()+"");
                    txtpunch.setVisibility(View.VISIBLE);*/

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }


            // Display the first 500 characters of the response string.
        txtJokes.setText("Response is: "+ ID);

        }
    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtJokes.setText("Cannot get data"+error.toString());
            }}) ;
        queue.add(jsonobjectRequest);
    }
}