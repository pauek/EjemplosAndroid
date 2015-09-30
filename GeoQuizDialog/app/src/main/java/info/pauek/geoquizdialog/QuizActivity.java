package info.pauek.geoquizdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private int curr_index;
    private Question curr_question;

    private TextView qtext, qnum;
    private RadioButton[] qanswer;
    private Button bnext, bprev;

    public void updateQuestion() {
        curr_question = Question.all_questions.get(curr_index);
        qtext.setText(curr_question.getText());
        qnum.setText(String.format("%d/%d", curr_index + 1, Question.all_questions.size()));
        for (int i = 0; i < curr_question.numAnswers(); i++) {
            qanswer[i].setText(curr_question.getAnswer(i));
            qanswer[i].setChecked(curr_question.getUserAnswer() == i);
        }
        bprev.setVisibility(curr_index == 0 ? View.GONE : View.VISIBLE);
        if (curr_index == Question.all_questions.size()-1) {
            bnext.setText(R.string.finish);
        } else {
            bnext.setText(R.string.next);
        }
    }

    public void answer(View view) {
        for (int i = 0; i < qanswer.length; i++) {
            if (qanswer[i] == view) {
                curr_question.setUserAnswer(i);
                return;
            }
        }
    }

    public void showFinalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.mark);
        builder.setMessage("Your score is: " + Question.score());
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                QuizActivity.this.finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void nextQuestion(View view) {
        if (curr_index == Question.all_questions.size() - 1) {
            showFinalDialog();
        } else {
            curr_index++;
            updateQuestion();
        }
    }

    public void prevQuestion(View view) {
        curr_index--;
        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curr_index", curr_index);
        outState.putIntegerArrayList("user_answers", Question.all_user_answers());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Referències a widgets
        qtext = (TextView) findViewById(R.id.question);
        qnum = (TextView) findViewById(R.id.qnum);
        bnext = (Button) findViewById(R.id.button_next);
        bprev = (Button) findViewById(R.id.button_prev);t
        qanswer = new RadioButton[4];
        qanswer[0] = (RadioButton) findViewById(R.id.answer1);
        qanswer[1] = (RadioButton) findViewById(R.id.answer2);
        qanswer[2] = (RadioButton) findViewById(R.id.answer3);
        qanswer[3] = (RadioButton) findViewById(R.id.answer4);

        // Carreguem preguntes
        Question.loadQuestionList(getResources().getStringArray(R.array.questions));

        if (savedInstanceState != null) {
            curr_index = savedInstanceState.getInt("curr_index");
            Question.setUserAnswers(savedInstanceState.getIntegerArrayList("user_answers"));
        }
        else {
            // Mostrem primera pregunta
            curr_index = 0;
            updateQuestion();
        }
    }

}
