package info.pauek.geoquizmulti;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    public class Pregunta {
        public String text;
        public boolean certa;

        public Pregunta(String text, boolean certa) {
            this.text = text;
            this.certa = certa;
        }
    }

    Pregunta[] preguntes;
    int pregunta_actual;

    private void refreshQuestion() {
        TextView preg = (TextView) findViewById(R.id.pregunta);
        preg.setText(preguntes[pregunta_actual].text);
        TextView qnum = (TextView) findViewById(R.id.qnum);
        qnum.setText(String.format("%d/%d", pregunta_actual + 1, preguntes.length));
    }

    private void initQuestions() {
        String[] P = getResources().getStringArray(R.array.preguntes);
        preguntes = new Pregunta[P.length];
        for (int i = 0; i < P.length; i++) {
            String[] parts = P[i].split("; ");
            preguntes[i] = new Pregunta(parts[0], parts[1].equals("true"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initQuestions();
        pregunta_actual = 0;
        refreshQuestion();

        Button btrue = (Button) findViewById(R.id.button_true);
        btrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res = R.string.incorrect;
                if (preguntes[pregunta_actual].certa) {
                    res = R.string.correct;
                }
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT)
                     .show();
                pregunta_actual = (pregunta_actual + 1) % preguntes.length;
                refreshQuestion();
            }
        });

        Button bfalse = (Button) findViewById(R.id.button_false);
        bfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res = R.string.correct;
                if (preguntes[pregunta_actual].certa) {
                    res = R.string.incorrect;
                }
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT)
                     .show();
                pregunta_actual = (pregunta_actual + 1) % preguntes.length;
                refreshQuestion();
            }
        });
    }
}
