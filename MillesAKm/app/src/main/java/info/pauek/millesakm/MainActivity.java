package info.pauek.millesakm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView edit_km;
    private TextView edit_miles;

    public void toKm(View view) {
        float miles = Float.parseFloat(edit_miles.getText().toString());
        edit_km.setText(String.format("%f", miles*1.609344));
    }

    public void toMiles(View view) {
        float km = Float.parseFloat(edit_km.getText().toString());
        edit_miles.setText(String.format("%f", km/1.609344));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_km = (TextView) findViewById(R.id.edit_km);
        edit_miles = (TextView) findViewById(R.id.edit_miles);
    }

}
