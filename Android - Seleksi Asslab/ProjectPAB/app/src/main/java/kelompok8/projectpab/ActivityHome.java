package kelompok8.projectpab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;


public class ActivityHome extends AppCompatActivity {
    ImageButton btnLogout, btnMulai, btnTambah;
    DatabaseHelper MyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_home);
        MyDB = new DatabaseHelper(this);

        btnMulai = (ImageButton) findViewById(R.id.mulaiTes);
        btnTambah = (ImageButton) findViewById(R.id.tmbhSoal);
        btnTambah.setVisibility(View.INVISIBLE);
        btnLogout = (ImageButton) findViewById(R.id.logout);
        btnLogout.setVisibility(View.INVISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.my_profil:
                Intent intent1 = new Intent(getApplicationContext(), ActivityProfil.class);
                startActivity(intent1);
                break;
            case R.id.about_us:
                Intent intent = new Intent(getApplicationContext(), ActivityAboutUs.class);
                startActivity(intent);
                break;
            case R.id.Logout:
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
        }
        return false;
    }



    public boolean onKeyDown(int keycode, KeyEvent event) {

        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }

    public void MulaiTes(View viewkloi) {
        Intent intent = new Intent(getApplicationContext(), ActivityQuestionShow.class);
        startActivity(intent);
    }

    public void Tambah(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityTambahSoal.class);
        startActivity(intent);
    }


    public void Logout(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}