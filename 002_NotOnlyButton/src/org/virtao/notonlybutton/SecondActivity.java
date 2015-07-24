package org.virtao.notonlybutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.second_layout);
		
		Button button1 = (Button) this.findViewById(R.id.button_second_1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
			
		});
		
		Button buttonReadExtraData = (Button)this.findViewById(R.id.button_second_activity_read_data);
		buttonReadExtraData.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = SecondActivity.this.getIntent();
				String data = intent.getStringExtra("extra_data");
				Toast.makeText(SecondActivity.this, "Extra data : " + data, Toast.LENGTH_SHORT).show();
			}
			
		});
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "I am from second activity.");
		setResult(RESULT_OK, intent);
		finish();
	}
	
	

}
