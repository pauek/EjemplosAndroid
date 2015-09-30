package edu.upc.eet.pma.exemples.intents3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {
	private TextView textViewSaludo;
	private String saludo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		saludo = getString(R.string.saludo);
		textViewSaludo = (TextView) findViewById(R.id.textViewSaludo);
		textViewSaludo.setText(String.format(saludo,"Mon"));
		Button askName = (Button) findViewById(R.id.buttonPersonalitzar);
		askName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startSecondActivity();
			}
		});
	}
		

	protected void startSecondActivity() {
		Intent intent = new Intent(this,ActivityTwo.class);
		startActivityForResult(intent, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == 1) {
	        if (resultCode == RESULT_OK) {
	        	String nom = data.getExtras().getString("nom");
	    		textViewSaludo.setText(String.format(saludo,nom));
	        }
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_one, menu);
		return true;
	}

}
