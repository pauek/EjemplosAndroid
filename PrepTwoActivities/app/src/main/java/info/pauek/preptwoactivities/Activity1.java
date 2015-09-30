package info.pauek.preptwoactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    private String message;
    private TextView messageView;

    private void refreshMessage() {
        messageView.setText(message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        message = getResources().getString(R.string.hello);
        messageView = (TextView)findViewById(R.id.message);
        refreshMessage();
    }

    public void onChange(View view) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("message", message);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:
                if (resultCode == Activity.RESULT_OK) {
                    message = data.getExtras().getString("message");
                    refreshMessage();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
