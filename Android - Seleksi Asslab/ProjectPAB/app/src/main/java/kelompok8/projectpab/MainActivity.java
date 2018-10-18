package kelompok8.projectpab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setButtonSignUp(View v) {
        //Button sign_up = (Button) findViewById(R.id.sign_up);
        Intent intent = new Intent(getApplicationContext(), ActivityRegistrasi.class);
        startActivity(intent);
    }


    public void setButtonLogin(View view) {
            //Button login = (Button) findViewById(R.id.login);
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);

    }
}