package edu.upc.eet.pma.exemples.intents2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityOne extends Activity {
	private EditText editTextNom;
	private Button buttonSaluda;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		editTextNom = (EditText) findViewById(R.id.editTextNom);
		buttonSaluda = (Button) findViewById(R.id.buttonSaluda);
		buttonSaluda.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startSecondActivity();				
			}
		});
	}

	protected void startSecondActivity() {
		Intent intent = new Intent(this,ActivityTwo.class);
		intent.putExtra("nom", editTextNom.getText().toString());
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_one, menu);
		return true;
	}

}
