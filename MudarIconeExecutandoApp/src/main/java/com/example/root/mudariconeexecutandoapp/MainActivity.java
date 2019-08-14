package com.example.root.mudariconeexecutandoapp;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alteraIcone(View v){
        Button button = (Button) v;
        disable();
        if(button.getText().toString().equals("Button"))
            mudaIcone("com.example.root.mudariconeexecutandoapp.MainActivity-One");
        else if(button.getText().toString().equals("Button2"))
            mudaIcone("com.example.root.mudariconeexecutandoapp.MainActivity-Two");
        else
            mudaIcone("com.example.root.mudariconeexecutandoapp.MainActivity-Three");

    }

    public void mudaIcone(String s){
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.example.root.mudariconeexecutandoapp", s), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    public void disable(){
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.example.root.mudariconeexecutandoapp", "com.example.root.mudariconeexecutandoapp.MainActivity-One"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.example.root.mudariconeexecutandoapp", "com.example.root.mudariconeexecutandoapp.MainActivity-Two"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        getPackageManager().setComponentEnabledSetting(new ComponentName("com.example.root.mudariconeexecutandoapp", "com.example.root.mudariconeexecutandoapp.MainActivity-Three"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}
