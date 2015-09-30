package info.pauek.preptwoactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle extras = getIntent().getExtras();
        String msg = extras.getString("message");
        edit = (EditText) findViewById(R.id.edit);
        edit.setText(msg);
    }

    public void onOk(View view) {
        Intent data = new Intent();
        data.putExtra("message", edit.getText().toString());
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}
