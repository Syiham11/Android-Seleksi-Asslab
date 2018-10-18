package kelompok8.projectpab;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ActivityQuestionBank {

    // declare list of Question objects
    List <ActivityQuestion> list = new ArrayList<>();
    DatabaseHelper mydb;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        mydb = new DatabaseHelper(context);
        list = mydb.getAllQuestionsList();//get questions/choices/answers from database

        /*if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            mydb.addInitialQuestion(new ActivityQuestion("1. Iraha android diciptakeun?",
                    new String[]{"2001", "2003", "2004", "2005"}, "2005"));
            mydb.addInitialQuestion(new ActivityQuestion("2. What is the name of build toolkit for Android Studio?",
                    new String[]{"JVM", "Gradle", "Dalvik", "HAXM"}, "Gradle"));
            mydb.addInitialQuestion(new ActivityQuestion("3. What widget can replace any use of radio buttons?",
                    new String[]{"Toggle Button", "Spinner", "Switch Button", "ImageButton"}, "Spinner"));
            mydb.addInitialQuestion(new ActivityQuestion("4. What is a widget in Android app?",
                    new String[]{"reusable GUI element", "Layout for Activity", "device placed in cans of beer", "build toolkit"}, "reusable GUI element"));

            list = mydb.getAllQuestionsList();
        //get list from database agai

        }*/
    }

}