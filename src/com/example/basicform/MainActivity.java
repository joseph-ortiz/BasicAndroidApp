package com.example.basicform;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "This is the 1st screen!", Toast.LENGTH_LONG).show();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("This program is malware! Trust me, this app does nothing.");
        alertBuilder.setMessage("Yes to Cancel or Resume to continue your app.")
        			.setCancelable(true)
        			.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							Toast.makeText(getApplicationContext(), "Your application will now close.", Toast.LENGTH_LONG).show();
							MainActivity.this.finish();
							
							
						}
        				
        			})
        			.setNegativeButton("Resume APP.", new DialogInterface.OnClickListener() {
						
        				
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getApplicationContext(), "Your application will now resume..", Toast.LENGTH_LONG).show();
							dialog.cancel();
							
						}
					})
					.create()
					.show();
        			
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);        
        Button sendButton = getButtonActivity(R.id.button1);
        return true;
    }
    
    private Button getButtonActivity(final int res)
    {
		Button tempButton = (Button) findViewById(res);
		tempButton.setOnClickListener(this);
		return tempButton;
    	
    }


	@Override
	public void onClick(View v) {
		
		
		
		if(v.getId() == R.id.button1){
			this.startActivity(new Intent(this,MyOtherActivity.class ));
		}
		
	}
    
}
