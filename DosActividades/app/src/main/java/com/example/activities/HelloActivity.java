package com.example.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloActivity extends Activity {
	
	private TextView mText;
	public static final int CANVIA_TEXT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        
        mText = (TextView)findViewById(R.id.text);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	switch (requestCode) {
    	case CANVIA_TEXT:
    		if (resultCode == Activity.RESULT_OK) {
    			mText.setText(data.getExtras().getString("text"));
    		}
    		break;
    	}
    	super.onActivityResult(requestCode, resultCode, data);
    }
    
    public void edita(View v) {
    	Intent intent = new Intent(this, EditaActivity.class);
    	intent.putExtra("text", mText.getText().toString());
    	startActivityForResult(intent, CANVIA_TEXT);
    }
}
