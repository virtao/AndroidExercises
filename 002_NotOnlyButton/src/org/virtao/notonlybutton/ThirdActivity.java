package org.virtao.notonlybutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.third_layout);
		
		Button button1 = (Button)this.findViewById(R.id.button_third_activity_1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = ThirdActivity.this.getIntent();
				Toast.makeText(ThirdActivity.this, "Third Activity : url : " + intent.getDataString(), Toast.LENGTH_SHORT).show();
			}
		});
	}

}
