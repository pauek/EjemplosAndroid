package info.pauek.counter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private int counter;

    TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
        } else {
            counter = 0;
        }

        counterView = (TextView) findViewById(R.id.counter);
        refreshCounter();
    }

    private void refreshCounter() {
        counterView.setText(String.format("%d", counter));
    }

    public void up(View view) {
        counter++;
        refreshCounter();
    }

    public void down(View view) {
        counter--;
        refreshCounter();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
}
