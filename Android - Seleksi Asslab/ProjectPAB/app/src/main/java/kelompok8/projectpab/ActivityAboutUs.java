package kelompok8.projectpab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Rudi Hidayat on 27/01/2018.
 */

public class ActivityAboutUs extends AppCompatActivity {

    private DatabaseHelper mydb;
    //private DatabaseHelperLogin mydb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_about_us);

        mydb = new DatabaseHelper(this);

        //btnLogin = (Button) findViewById(R.id.btnlogin);
    }
}