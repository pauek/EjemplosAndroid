package edu.upc.eet.pma.exemples.intents2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;


public class ActivityTwo extends Activity {
	private TextView textViewSaludo;
	private String saludo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		saludo = getString(R.string.saludo);
		textViewSaludo = (TextView) findViewById(R.id.textViewSaludo);
		textViewSaludo.setText(String.format(saludo, getNom()));
	}
	
	private String getNom() {
		Bundle bundle = getIntent().getExtras();
		return bundle.getString("nom");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_one, menu);
		return true;
	}

}
