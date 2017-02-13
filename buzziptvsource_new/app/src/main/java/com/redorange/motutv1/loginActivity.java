package com.redorange.motutv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.extremeiptv.buzziptv.R;

public class loginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_login);
        Intent rcvIntent=getIntent();
        ((TextView) findViewById(R.id.txt_content)).setText(rcvIntent.getStringExtra(starterActivity.msg_sn));
        // Button click eventListner
        ((Button) findViewById(R.id.btn_quit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                //toStarter();
                //return;
            }
        });
        ((Button) findViewById(R.id.btn_reconnect)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLiveTv();
                return;
            }
        });
    }
    public void toStarter()
    {
        //Intent toLoginIntent = new Intent(this,starterActivity.class);
        //startActivity(toLoginIntent);
        android.os.Process.killProcess(android.os.Process.myPid());
        return;
    }
    public void toLiveTv()
    {
        Intent toLoginIntent = new Intent(this,LiveTvActivity.class);
        startActivity(toLoginIntent);
        return;
    }
}
