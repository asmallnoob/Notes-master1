package net.micode.notes.ui;


import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.micode.notes.R;

public class resetpassword extends Activity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText passwordEdit;
    private EditText newPassword;
    private EditText confirmPassword;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        passwordEdit = (EditText) findViewById(R.id.passwordEdit);
        newPassword = (EditText) findViewById(R.id.newPassword);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        confirm = (Button) findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordEdit.getText().toString();
                String password1 = newPassword.getText().toString();
                String password2 = confirmPassword. getText().toString();
                String passwordRecord = pref.getString("password","123456");

                if(password.equals(passwordRecord)){
                    if(password1.equals(password2)){
                        editor = pref.edit();
                        editor.putString("password", password1);
                        editor.apply();
                        Toast.makeText(resetpassword.this,"密码更改成功",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(resetpassword.this,"请确认两次输入的密码相同...",
                                Toast.LENGTH_SHORT).show();
                    }}
                else {
                    Toast.makeText(resetpassword.this,"原密码错误,请重新输入",
                            Toast.LENGTH_SHORT).show();
                }
            }




        });
    }


}
