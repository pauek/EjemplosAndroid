package edu.upc.eet.pma.exemples.intents3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class ActivityTwo extends Activity {
	private EditText editTextNom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		editTextNom = (EditText) findViewById(R.id.editTextNom);
		Button button = (Button) findViewById(R.id.buttonSaluda);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	
	@Override
	public void finish() {
	  	Intent data = new Intent();
	  	data.putExtra("nom", editTextNom.getText().toString());
	  	setResult(RESULT_OK, data);
	  	super.finish();
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_one, menu);
		return true;
	}

}
