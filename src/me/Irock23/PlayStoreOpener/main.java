package me.Irock23.PlayStoreOpener;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Toast;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	Timer lTimer = new Timer();
    	lTimer.schedule(new LaunchS(), 100);
    }
    
    class LaunchS extends TimerTask {
    	public void run() {
    		Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
        	if(isCallable(intent)) {
            	startActivity(intent);
        	} else {
        		MsgBox("Google Play Store not found!");
        	}
        	finish();
    	}
    }
    
    private boolean isCallable(Intent intent) {  
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);  
        return list.size() > 0;  
    }
    
    public void MsgBox(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}