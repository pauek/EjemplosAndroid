package info.pauek.geoquizdialog;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by pauek on 22/09/15.
 */
public class Question {
    private String text;
    private String[] answers;
    private int correct_answer;
    private int user_answer = -1;

    public static ArrayList<Question> all_questions = new ArrayList<Question>();

    private Question(String resource_text) {
        // format de la pregunta "text;a1;a2;a3;a4;N"
        String[] parts = resource_text.split(";");
        this.text = parts[0];
        this.answers = new String[parts.length - 2];
        for (int i = 0; i < parts.length - 2; i++) {
            this.answers[i] = parts[i + 1];
        }
        this.correct_answer = Integer.parseInt(parts[parts.length - 1]);
    }

    public String getText() {
        return text;
    }

    public int numAnswers() {
        return answers.length;
    }

    public String getAnswer(int n) {
        return this.answers[n];
    }

    public String correctAnswer() {
        return this.answers[this.correct_answer];
    }

    public int getUserAnswer() {
        return user_answer;
    }

    public void setUserAnswer(int user_answer) {
        Log.i("GeoQuiz", "setAnswer: " + user_answer);
        this.user_answer = user_answer;
    }

    public static void loadQuestionList(String[] array) {
        all_questions = new ArrayList<Question>();
        for (int i = 0; i < array.length; i++) {
            all_questions.add(new Question(array[i]));
        }

    }

    public static int score() {
        int cont = 0;
        for (int i = 0; i < all_questions.size(); i++) {
            Question Q = all_questions.get(i);
            if (Q.correct_answer == Q.user_answer) {
                cont++;
            }
        }
        return cont;
    }

    public static ArrayList<Integer> all_user_answers() {
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < all_questions.size(); i++) {
            A.add(all_questions.get(i).getUserAnswer());
        }
        return A;
    }

    public static void setUserAnswers(ArrayList<Integer> user_answers) {
        for (int i = 0; i < user_answers.size(); i++) {
            all_questions.get(i).setUserAnswer(user_answers.get(i));
        }
    }
}

