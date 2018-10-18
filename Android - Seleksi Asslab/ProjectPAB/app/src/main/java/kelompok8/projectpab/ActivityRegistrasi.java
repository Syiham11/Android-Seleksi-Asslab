package kelompok8.projectpab;

import android.content.DialogInterface;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityRegistrasi extends AppCompatActivity implements TextWatcher {

    private DatabaseHelper mydb;
    EditText nim, nama, alamat, tgl_lahir, prodi, kelas, email, no_hp, username, password;
    TextView jk;
    public String[] dataprodi = {"Manajemen Informatika", "Sistem Informasi", "Teknik Informatika"};
    //EditText fprodi;
    RadioGroup grup;
    RadioButton laki_laki, perempuan;
    //RadioButton jk;
    Button btnDaftar;

    //String id_To_Update = "";

    public void pilihprodi(View v) {
        prodi = (EditText) findViewById(R.id.fprodi);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(dataprodi, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                prodi.setText(dataprodi[item]);
                dialog.dismiss();
            }
        }).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_registrasi);

        nim = (EditText) findViewById(R.id.fnim);
        nama = (EditText) findViewById(R.id.fnama);
        alamat = (EditText) findViewById(R.id.falamat);

        /*grup = (RadioGroup) findViewById(R.id.rgJk);
        int selectedId = grup.getCheckedRadioButtonId();

        String hasil="";
        laki_laki = (RadioButton) findViewById(R.id.rbLaki_laki);
        perempuan = (RadioButton) findViewById(R.id.rbPerempuan);

        if (laki_laki.isChecked()) {
            hasil = laki_laki.getText().toString();
            jk.setText(hasil);
        } else if (perempuan.isChecked()) {
            hasil = laki_laki.getText().toString();
            jk.setText(hasil);
        }*/
        jk = (EditText) findViewById(R.id.fjk);
        tgl_lahir = (EditText) findViewById(R.id.ftgl_lahir);
       // prodi = (TextView) findViewById(R.id.fprodi);
        prodi = (EditText) findViewById(R.id.fprodi);
        kelas = (EditText) findViewById(R.id.fkelas);
        email = (EditText) findViewById(R.id.femail);
        no_hp = (EditText) findViewById(R.id.fnohp);
        username = (EditText) findViewById(R.id.fusername);
        password = (EditText) findViewById(R.id.fpassword);
        btnDaftar=(Button) findViewById(R.id.daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanPendaftaran();
            }
        });
        mydb = new DatabaseHelper(ActivityRegistrasi.this);

    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void afterTextChanged(Editable s) {
    }

    public void setTanggal(View v) {
        final Calendar c = Calendar.getInstance();
        int thn = c.get(Calendar.YEAR);
        int bln = c.get(Calendar.MONTH);
        int tgl = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityRegistrasi.this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int thn, int bln, int tgl)
            {
                tgl_lahir.setText(tgl + "-" + (bln+ 1) + "-" + thn);
            }
        }, thn, bln, tgl);
        datePickerDialog.show();
    }


    public void simpanPendaftaran() {
        if (mydb.insertPendaftaran(nim.getText().toString(), nama.getText().toString(), alamat.getText().toString(), jk.getText().toString(), tgl_lahir.getText().toString(), prodi.getText().toString(), kelas.getText().toString(), email.getText().toString(), no_hp.getText().toString(), username.getText().toString(), password.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Input Data Berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Input Data Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}