package org.virtao.notonlybutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

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
	}

}
