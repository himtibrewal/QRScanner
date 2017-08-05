package esecforte.com.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_login;
    private EditText etDetil, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();
    }

    private void findId() {
        etDetil = (EditText) findViewById(R.id.et_login);
        tv_login = (TextView) findViewById(R.id.tv_login);
        etPassword = (EditText) findViewById(R.id.et_password);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }


    private void validate() {
        if (etDetil.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "please Enter user id", Toast.LENGTH_LONG).show();
            return;
        } else if (etPassword.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "please Enter password", Toast.LENGTH_LONG).show();
            return;
        } else {
            Intent i = new Intent(LoginActivity.this, StoreActivity.class);
            startActivity(i);
            finish();
        }
    }
}
