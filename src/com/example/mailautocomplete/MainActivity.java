package com.example.mailautocomplete;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AutoCompleteTextView;

/**
 * 
 * @author xiaofan
 *  2013-06-24
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AutoCompleteTextView mail = (AutoCompleteTextView) findViewById(R.id.mail);
		AutoCompleteAdapter adapter = new AutoCompleteAdapter(this, android.R.layout.simple_dropdown_item_1line);
		mail.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
