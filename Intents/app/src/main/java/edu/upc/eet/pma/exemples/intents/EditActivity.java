package edu.upc.eet.pma.exemples.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {
	private EditText mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		Intent intent = getIntent();
		String html = intent.getExtras().getString(MainActivity.HTML_KEY);
		mEdit = (EditText)findViewById(R.id.editText1);
		mEdit.setText(html);
		setResult(RESULT_CANCELED, null);
	}
	
	public void onDone(View v) {
		String html = mEdit.getText().toString();
		Intent intent = new Intent();
		intent.putExtra(MainActivity.HTML_KEY, html);
		setResult(RESULT_OK, intent);
		finish();
	}

}
