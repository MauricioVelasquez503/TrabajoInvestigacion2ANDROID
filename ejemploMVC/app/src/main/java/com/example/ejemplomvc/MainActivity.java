package com.example.ejemplomvc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ejemplomvc.controller.IloginController;
import com.example.ejemplomvc.controller.LoginController;
import com.example.ejemplomvc.View.ILoginView;
public class MainActivity extends AppCompatActivity  implements ILoginView {
    EditText email,password;
    Button loginb;
    IloginController loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.loginb);
        loginPresenter = new LoginController(this);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }
    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}