package kelompok8.projectpab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "db_asslab.db", null, 1);
    }

    private static final String TABLE_QUESTION = "QuestionBank";
    // All fields used in database table
    private static final String KEY_ID = "id";
    private static final String QUESTION = "question";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";
    private static final String ANSWER = "answer";

    // Question Table Create Query in this string
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE "
            + TABLE_QUESTION + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + " TEXT, " + CHOICE2 + " TEXT, " + CHOICE3 + " TEXT, "
            + CHOICE4 + " TEXT, " + ANSWER + " TEXT);";


    @Override
    public void onCreate(SQLiteDatabase db) {         // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE pendaftaran (nim VARCHAR PRIMARY KEY, nama VARCHAR, alamat VARCHAR, jk VARCHAR, tgl_lahir VARCHAR, prodi VARCHAR, kelas VARCHAR, email VARCHAR, no_hp VARCHAR, username VARCHAR, password VARCHAR)");
        db.execSQL(CREATE_TABLE_QUESTION); // create question table
    }


    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion)
    {         // TODO Auto-generated methods
        db.execSQL("DROP TABLE IF EXISTS pendaftaran");
        onCreate(db);
    }

    public boolean insertPendaftaran (String nim, String nama, String alamat, String jk, String tgl_lahir, String prodi, String kelas, String email, String no_hp, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", nim);
        contentValues.put("nama", nama);
        contentValues.put("alamat", alamat);
        contentValues.put("jk", jk);
        contentValues.put("tgl_lahir", tgl_lahir);
        contentValues.put("prodi", prodi);
        contentValues.put("kelas", kelas);
        contentValues.put("email", email);
        contentValues.put("no_hp", no_hp);
        contentValues.put("username", username);
        contentValues.put("password", password);

        db.insert("pendaftaran", null, contentValues);
        return true;
    }

    public boolean tambahSoal(String question, String choice1, String choice2, String choice3, String choice4, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("question", question);
        contentValues.put("choice1", choice1);
        contentValues.put("choice2", choice2);
        contentValues.put("choice3", choice3);
        contentValues.put("choice4", choice4);
        contentValues.put("answer", answer);

        db.insert("QuestionBank", null, contentValues);
        return true;
    }



    public List<ActivityQuestion> getAllQuestionsList() {
        List<ActivityQuestion> questionArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                ActivityQuestion question = new ActivityQuestion();

                String questText= c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);

                String choice1Text= c.getString(c.getColumnIndex(CHOICE1));
                question.setChoice(0,choice1Text);

                String choice2Text= c.getString(c.getColumnIndex(CHOICE2));
                question.setChoice(1,choice2Text);

                String choice3Text= c.getString(c.getColumnIndex(CHOICE3));
                question.setChoice(2,choice3Text);

                String choice4Text= c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(3,choice4Text);

                String answerText= c.getString(c.getColumnIndex(ANSWER));
                question.setAnswer(answerText);

                // adding to Questions list
                questionArrayList.add(question);
            } while (c.moveToNext());
            Collections.shuffle(questionArrayList);
        }
        return questionArrayList;
    }



    public Cursor getData (String nim){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from pendaftaran where nim='" + nim +"'", null);
        return res;
    }

    public int numberOfRows () {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "pendaftaran");
        return numRows;
    }

    public boolean updatePendaftaran (String nim, String nama, String alamat, String jk, String tgl_lahir, String prodi, String kelas, String email, String no_hp, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", nim);
        contentValues.put("nama", nama);
        contentValues.put("alamat", alamat);
        contentValues.put("jk", jk);
        contentValues.put("tgl_lahir", tgl_lahir);
        contentValues.put("prodi", prodi);
        contentValues.put("kelas", kelas);
        contentValues.put("email", email);
        contentValues.put("no_hp", no_hp);
        contentValues.put("username", username);
        contentValues.put("password", password);

        db.update("pendaftaran", contentValues, "nim = ? ", new String[]{nim});
        return true;
    }
}
