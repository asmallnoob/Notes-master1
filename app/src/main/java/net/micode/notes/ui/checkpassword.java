package net.micode.notes.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.micode.notes.R;

public class checkpassword extends Activity {

    private SharedPreferences pref;

    private EditText passwordEdit;

    private Button login;

    public static int RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.checkpassword);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEdit.getText().toString();
                String password1 = pref.getString("password","123456");
                Toast.makeText(checkpassword.this,password1,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                if ( password.equals(password1)) {
                    RESULT_CODE = 1;
                    setResult(RESULT_CODE,intent);
                    finish();
                }
            }
        });
    }

}