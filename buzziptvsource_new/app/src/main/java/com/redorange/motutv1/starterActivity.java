package com.redorange.motutv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.extremeiptv.buzziptv.R;
import com.redorange.motutv1.app.Motutv1Application;
import com.redorange.motutv1.dialog.LoadPhotoDialog;


public class starterActivity extends Activity{

    //AuthConfig authConfig= new AuthConfig(this);
    //UpdateUserService updateUser = new UpdateUserService(this);
    Motutv1Application mApp;
    //Context m_con;
    LoadPhotoDialog dialog;
    public final  static String msg_sn="My_SerialNumber";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        this.mApp = ((Motutv1Application)getApplication());
        this.dialog=new LoadPhotoDialog(this,R.style.dialog);


        ((Button) findViewById(R.id.btn_sn)).setText(mApp.getSN());

        // Button click eventListner
        ((Button) findViewById(R.id.btn_quit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                return;
            }
        });
        ((Button) findViewById(R.id.btn_retry)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button) findViewById(R.id.btn_retry)).setVisibility(View.INVISIBLE);
                ((Button) findViewById(R.id.btn_quit)).setVisibility(View.INVISIBLE);
                ((Button) findViewById(R.id.btn_sn)).setVisibility(View.INVISIBLE);
                dialog.show();
                toLogin();
                return;
            }
        });
        //
    }
    public void toLogin()
    {
        this.dialog.show();
        Intent toLoginIntent = new Intent(this,loginActivity.class);
        String message = this.mApp.getSN();
        toLoginIntent.putExtra(msg_sn, message);
        startActivity(toLoginIntent);
        return;

    }

}

