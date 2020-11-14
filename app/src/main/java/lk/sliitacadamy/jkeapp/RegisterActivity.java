package lk.sliitacadamy.jkeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ShareActionProvider;

public class RegisterActivity extends AppCompatActivity {

    EditText txtUsername,txtEmail,txtMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtUsername=findViewById(R.id.txtUserName);
        txtEmail=findViewById(R.id.txtEmail);
        txtMobile=findViewById(R.id.txtPassword);
    }


    public void onRegisterTapped(View view) {
        String name=txtUsername.getText().toString();// empty or null text box
        if(name.isEmpty()){
            txtUsername.setError("please fill username");
            return;
        }
        String email=txtEmail.getText().toString();// empty or null text box
        if(email.isEmpty()){
            txtEmail.setError("please fill email box");
            return;
        }
        String phone=txtMobile.getText().toString();// empty or null text box
        if(phone.isEmpty()){
            txtMobile.setError("please type phone number");
            return;
        }

        final User user=new User(name,email,Integer.parseInt(phone));

        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
        builder.setTitle("Sucess");
        builder.setMessage("congrats u have sucessfully Registered");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                SharedPreferences preferences=getApplicationContext().getSharedPreferences(getString(R.string.PREF_User), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(getString(R.string.PREF_User), user.getEmail());
                editor.apply();


                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                intent.putExtra(Constants.key_Name,user.getName());
                intent.putExtra(Constants.key_Email,user.getEmail());
                intent.putExtra(Constants.key_Mobile,user.getPassword());


                startActivity(intent);
            }

        });
        builder.show();

    }
}