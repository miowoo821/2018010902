package com.example.student.a2018010902;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String idlover="love";
    NotificationChannel channellove;
    NotificationManager nm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

       if(Build.VERSION.SDK_INT>=26){
           regchannel();
       }
    }

   @TargetApi(Build.VERSION_CODES.O)
    public void regchannel() {
        channellove = new NotificationChannel(idlover, "CLOVE", NotificationManager.IMPORTANCE_HIGH);
        channellove.setDescription("敘述1");
        channellove.enableLights(true);
        channellove.enableVibration(true);

        nm.createNotificationChannel(channellove);
        }

        @TargetApi(26)
        @SuppressWarnings("deprecation")


        public void click1(View v){
        Notification.Builder builder;
        if(Build.VERSION.SDK_INT>=26) {
            builder=new Notification.Builder(MainActivity.this,idlover);
        }
        else{
            builder = new Notification.Builder(MainActivity.this);
        }

            builder.setContentTitle("標題"); //這三行必填，是通知的內容
            builder.setContentText("內容"); //這三行必填，是通知的內容
            builder.setSmallIcon(R.drawable.ic_launcher_background); //這三行必填，是通知的內容

            Notification notify=builder.build();
            nm.notify(1,notify);
    }



}
