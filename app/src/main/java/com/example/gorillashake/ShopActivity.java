package com.example.gorillashake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Phone;
    private EditText Address;
    private RadioGroup group1;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioGroup group2;

    private RadioButton btn3;
    private RadioButton btn4;
    private RadioGroup group3;
    private RadioButton ibtn1;
    private RadioButton ibtn2;
    private RadioButton ibtn3;
    private CheckBox checkyes;
    private TextView Username;
    private TextView Userphone;
    private TextView Useraddress;
    private TextView Usermeth;
    private TextView Useritem;
    private TextView Usersuccess;

    private Button btnhome;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Name = (EditText) findViewById(R.id.inputName);
        Phone = (EditText) findViewById(R.id.inputPhone);
        Address = (EditText) findViewById(R.id.inputaddress);
        group1 = (RadioGroup) findViewById(R.id.radiogroup1);
        btn1 = (RadioButton) findViewById(R.id.btn1);
        btn2 = (RadioButton) findViewById(R.id.btn2);

        group3 = (RadioGroup) findViewById(R.id.radiogroup1);
        ibtn1 = (RadioButton) findViewById(R.id.ibtn1);
        ibtn2 = (RadioButton) findViewById(R.id.ibtn2);
        ibtn3 = (RadioButton) findViewById(R.id.ibtn3);
        checkyes = (CheckBox) findViewById(R.id.checkyes);

        btnhome = (Button) findViewById(R.id.btnhome);


        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));

            }
        });




    }

    public void gorilla(View view) {
        setContentView(R.layout.gorilla);
        Username = (TextView) findViewById(R.id.username);
        Username.setTextColor(Color.WHITE);
        Username.setBackgroundColor(Color.BLUE);
        Username.setText(Name.getText());

        Userphone = (TextView) findViewById(R.id.userphone);
        Userphone.setTextColor(Color.WHITE);
        Userphone.setBackgroundColor(Color.BLUE);
        Userphone.setText(Phone.getText());

        Useraddress = (TextView) findViewById(R.id.useraddress);
        Useraddress.setTextColor(Color.WHITE);
        Useraddress.setBackgroundColor(Color.BLUE);
        Useraddress.setText(Address.getText());


        Usermeth = (TextView) findViewById(R.id.usermeth);
        Usermeth.setTextColor(Color.WHITE);
        if (btn1.isChecked()) {
            Usermeth.setBackgroundColor(Color.GRAY);
            Usermeth.setText("Debit card");
        }
        if (btn2.isChecked()) {
            Usermeth.setBackgroundColor(Color.GRAY);
            Usermeth.setText("Paypal");
        }

        Useritem  = (TextView) findViewById(R.id.useritem);
        Useritem.setTextColor(Color.WHITE);
        if (ibtn1.isChecked()) {
            Useritem.setBackgroundColor(Color.GRAY);
            Useritem.setText("Vanilla");
        }
        if (ibtn2.isChecked()) {
            Useritem.setBackgroundColor(Color.RED);
            Usermeth.setText("Chocolate");
        }
        if (ibtn3.isChecked()) {
            Useritem.setBackgroundColor(Color.MAGENTA);
            Useritem.setText("Strawberry");
        }
        Usersuccess  = (TextView) findViewById(R.id.usersuccess);
        Usersuccess.setTextColor(Color.WHITE);
        if (checkyes.isChecked()) {
            Usersuccess.setBackgroundColor(Color.GREEN);
            Usersuccess.setText("Successful");
        }else{
            Usersuccess.setBackgroundColor(Color.RED);
            Usersuccess.setText("Unsuccessful, please try again");

        }


    }
}