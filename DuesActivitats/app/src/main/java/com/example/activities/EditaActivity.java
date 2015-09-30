package com.example.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditaActivity extends Activity {
	private EditText mText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edita);

		mText = (EditText)findViewById(R.id.text);
		Bundle params = getIntent().getExtras();
		if (params != null) {
			mText.setText(params.getString("text"));
		}
	}
	
	public void ok(View v) {
		Intent intent = new Intent();
		intent.putExtra("text", mText.getText().toString());
		setResult(Activity.RESULT_OK, intent);
		finish();
	}
}
