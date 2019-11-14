package com.example.time_line;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import GetInformation.Login;
import entity.Check_username;

public class CreateActivity extends AppCompatActivity {
    private EditText editText1,editText2,editText3;
    private Button button;
    private String check_url="http://10.0.2.2:8080/Time_Line/Check_username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        editText1=findViewById(R.id.username);
        editText2=findViewById(R.id.userpassword);
        editText3=findViewById(R.id.userpassword_check);
        button=findViewById(R.id.create_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText2.getText().toString()!=editText3.getText().toString()){
                    Toast.makeText(CreateActivity.this,"两次输入的密码不一致，请重新输入",Toast.LENGTH_LONG).show();
                    editText2.setText("");
                    editText3.setText("");
                }
                else {
                    Login login=new Login();
                    String username=editText1.getText().toString();
                    String petname=editText2.getText().toString();
                    String password=editText3.getText().toString();
                    Check_username check_uesrname=new Check_username(username,petname,password);
                    String result=login.Create_check_uesrname(check_uesrname,check_url);
                    switch (result){
                        case "true":
                            Intent intent=new Intent();
                            intent.putExtra("uame",check_uesrname.getUsername());
                            intent.putExtra("petname",check_uesrname.getPetname());
                            intent.putExtra("upwd",check_uesrname.getUserpassword());
                            setResult(1,intent);
                            finish();
                            break;
                        case "false":
                            Toast.makeText(CreateActivity.this,"用户名已被注册",Toast.LENGTH_LONG).show();
                            editText1.setText("");
                            break;
                        case "网络无法连接":
                            break;
                        case "未知错误":
                            break;
                    }
                }
            }
        });
    }
}
