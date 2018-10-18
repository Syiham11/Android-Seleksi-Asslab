package kelompok8.projectpab;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rudi Hidayat on 27/01/2018.
 */

public class ActivityProfil extends AppCompatActivity {

    private DatabaseHelper mydb;
    EditText nim, nama, alamat, jk, tgl_lahir, prodi, kelas, email, no_hp, username, password;
    //private DatabaseHelperLogin mydb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_edit_profil);

        nim = (EditText) findViewById(R.id.fnim);
        nama = (EditText) findViewById(R.id.fnama);
        alamat = (EditText) findViewById(R.id.falamat);

        jk = (EditText) findViewById(R.id.fjk);
        tgl_lahir = (EditText) findViewById(R.id.ftgl_lahir);
        // prodi = (TextView) findViewById(R.id.fprodi);
        prodi = (EditText) findViewById(R.id.fprodi);
        kelas = (EditText) findViewById(R.id.fkelas);
        email = (EditText) findViewById(R.id.femail);
        no_hp = (EditText) findViewById(R.id.fnohp);
        username = (EditText) findViewById(R.id.fusername);
        password = (EditText) findViewById(R.id.fpassword);

        mydb = new DatabaseHelper(this);

        Cursor rs = mydb.getData("2014081042");
        rs.moveToFirst();
        String val_nim = rs.getString(rs.getColumnIndex("nim"));
        String val_nama = rs.getString(rs.getColumnIndex("nama"));
        String val_alamat = rs.getString(rs.getColumnIndex("alamat"));
        String val_jk = rs.getString(rs.getColumnIndex("jk"));
        String val_tgl_lahir = rs.getString(rs.getColumnIndex("tgl_lahir"));
        String val_prodi = rs.getString(rs.getColumnIndex("prodi"));
        String val_kelas = rs.getString(rs.getColumnIndex("kelas"));
        String val_email = rs.getString(rs.getColumnIndex("email"));
        String val_no_hp = rs.getString(rs.getColumnIndex("no_hp"));
        String val_username = rs.getString(rs.getColumnIndex("username"));
        String val_password = rs.getString(rs.getColumnIndex("password"));
        if (!rs.isClosed()) {
            rs.close();
        }

        Button b = (Button) findViewById(R.id.edit_profil);
        b.setVisibility(View.VISIBLE);

        nim.setText(val_nim);
        nim.setEnabled(true);
        nim.setFocusableInTouchMode(true);
        nim.setClickable(true);

        nama.setText(val_nama);
        nama.setEnabled(true);
        nama.setFocusableInTouchMode(true);
        nama.setClickable(true);

        alamat.setText(val_alamat);
        alamat.setEnabled(true);
        alamat.setFocusableInTouchMode(true);
        alamat.setClickable(true);

        jk.setText(val_jk);
        jk.setEnabled(true);
        jk.setFocusableInTouchMode(true);
        jk.setClickable(true);

        tgl_lahir.setText(val_tgl_lahir);
        tgl_lahir.setEnabled(true);
        tgl_lahir.setFocusableInTouchMode(true);
        tgl_lahir.setClickable(true);

        prodi.setText(val_prodi);
        prodi.setEnabled(true);
        prodi.setFocusableInTouchMode(true);
        prodi.setClickable(true);
        
        kelas.setText(val_kelas);
        kelas.setEnabled(true);
        kelas.setFocusableInTouchMode(true);
        kelas.setClickable(true);

        email.setText(val_email);
        email.setEnabled(true);
        email.setFocusableInTouchMode(true);
        email.setClickable(true);

        no_hp.setText(val_no_hp);
        no_hp.setEnabled(true);
        no_hp.setFocusableInTouchMode(true);
        no_hp.setClickable(true);

        username.setText(val_username);
        username.setEnabled(true);
        username.setFocusableInTouchMode(true);
        username.setClickable(true);

        password.setText(val_password);
        password.setEnabled(true);
        password.setFocusableInTouchMode(true);
        password.setClickable(true);
    }

    public void editProfil(View view) {
        if (mydb.updatePendaftaran(nim.getText().toString(), nama.getText().toString(), alamat.getText().toString(), jk.getText().toString(), tgl_lahir.getText().toString(), prodi.getText().toString(), kelas.getText().toString(), email.getText().toString(), no_hp.getText().toString(), username.getText().toString(), password.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Edit Data Berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Edit Data Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}