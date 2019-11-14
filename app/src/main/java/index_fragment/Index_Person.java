package index_fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.time_line.R;

import GetInformation.Login;
import GetInformation.MyDatabaseHelper;

public class Index_Person extends Fragment {
    private FrameLayout frameLayout;
    private Fragment fragment1,fragment2;
    FragmentTransaction fragmentTransaction;
    MyDatabaseHelper myDatabaseHelper;
    String username,petname,password;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myDatabaseHelper=new MyDatabaseHelper(getContext(),"UserInfo.db",null,1);
        myDatabaseHelper.getWritableDatabase();
        return inflater.inflate(R.layout.fragment_index_person,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frameLayout=view.findViewById(R.id.person_index_framelayout);
        fragment1=new Login_fragment();
        fragment2=new Logined_fragment();
        SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
        Cursor cursor= db.query("user_info",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                username=cursor.getString(cursor.getColumnIndex("username"));
                petname=cursor.getString(cursor.getColumnIndex("petname"));
                password=cursor.getString(cursor.getColumnIndex("password"));
            }while (cursor.moveToLast());
        }
        if(username!=null){

        }
    }
    public boolean toLogin(String username,String password){
        String url="http://10.0.2.2:8080/Time_Line/";
        Login login=new Login();
        String result=login.login(username,password,url);
        switch (result){
            case "true":

        }
        return false;
    }
}
