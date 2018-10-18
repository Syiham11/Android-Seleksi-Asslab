package kelompok8.projectpab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTambahSoal extends AppCompatActivity {

    private DatabaseHelper mydb;
    EditText pertanyaan, choice1,choice2,choice3,choice4,jawaban;

    //String id_To_Update = "";hyg

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_question);

        pertanyaan = (EditText) findViewById(R.id.pertanyaan);
        choice1 = (EditText) findViewById(R.id.choice1);
        choice2 = (EditText) findViewById(R.id.choice2);
        choice3 = (EditText) findViewById(R.id.choice3);
        choice4 = (EditText) findViewById(R.id.choice4);
        jawaban = (EditText) findViewById(R.id.jawaban);

        mydb = new DatabaseHelper(ActivityTambahSoal.this);
    }


    public void simpanSoal(View view) {
        if (mydb.tambahSoal(pertanyaan.getText().toString(), choice1.getText().toString(), choice2.getText().toString(), choice3.getText().toString(), choice4.getText().toString(), jawaban.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Input Soal Berhasil", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Input Soal Gagal", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
        startActivity(intent);

    }
}