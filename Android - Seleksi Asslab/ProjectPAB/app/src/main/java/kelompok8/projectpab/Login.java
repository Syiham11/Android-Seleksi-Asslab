package kelompok8.projectpab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    private DatabaseHelper mydb;
    //private DatabaseHelperLogin mydb1;
    Button btnLogin;
    EditText l_username, l_password;
    String Username = "devi", Password = "devi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_login);

        mydb = new DatabaseHelper(this);

        l_username = (EditText) findViewById(R.id.l_username);
        l_password = (EditText) findViewById(R.id.l_password);
        //btnLogin = (Button) findViewById(R.id.btnlogin);
    }


    public void saveLogin(View view) {
        String User = l_username.getText().toString();
        String Pass = l_password.getText().toString();
        if(User.equals("") || Pass.equals("")) {
            Toast.makeText(this, "Form Masih Kosong!", Toast.LENGTH_SHORT).show();
        }else{
            if(!User.equals(Username) || !Pass.equals(Password)){
                Toast.makeText(this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Berhasil Login!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
                startActivity(intent);
            }

            }

        }
}