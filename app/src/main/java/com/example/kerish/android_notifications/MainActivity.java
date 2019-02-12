package com.example.kerish.android_notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String id1 = "0001";
    public static String id2 = "0002";
    public static String id3 = "0003";
    public static String id4 = "0004";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleNotification(View view){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id1);
        builder.setAutoCancel(true);
        builder.setContentTitle("Simple Title");
        builder.setContentText("This is the body of simple notification");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setPriority(2);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    public void InboxNotification(View view){
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Inbox Sytle Title");
        inboxStyle.setSummaryText("This is Summary!");
        inboxStyle.addLine("THis is Line 1");
        inboxStyle.addLine("THis is Line 2");
        inboxStyle.addLine("THis is Line 3");
        inboxStyle.addLine("THis is Line 4");
        inboxStyle.addLine("THis is Line 5");
        inboxStyle.addLine("THis is Line 6");
        inboxStyle.addLine("THis is Line 7");
        inboxStyle.addLine("THis is Line 8");
        inboxStyle.addLine("THis is Line 9");
        inboxStyle.addLine("THis is Line 10");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id2);
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Simple Title");
        builder.setContentText("This is the body of Simple notification");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setStyle(inboxStyle);
        builder.setPriority(1);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(01, builder.build());
    }

    public void bigText(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Big Text Title");
        bigTextStyle.bigText("An operating system is a program that manages the computer hardware. It also provides a basis for application programs and acts as an intermediary between the computer user  and the computer hardware. An amazing aspect of operating systems is how varied they are in accomplishing these tasks. Mainframe operating system are designed primarily to optimize utilization of hardware. Personal  computer operating systems support complex games, business applications and everything in between. Operating systems for handheld computers are designed to provide an environment in which a user can that of easily interface with the computer to execute programs. Thus, some operating systems are designed to be convenient, others to be efficient, and others some combination of the two.");
        bigTextStyle.setSummaryText("Big text summary!");

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id3);
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Simple Title");
        builder.setContentText("This is the body of Simple notification");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setLargeIcon(icon);
        builder.setContentIntent(pendingIntent);
        builder.setStyle(bigTextStyle);
        builder.setPriority(0);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(02, builder.build());
    }

    public void bigImage(View view){

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle("Big Picture Title");
        bigPictureStyle.setSummaryText("Big Picture Summary!");
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.cookies)).build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id4);
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Simple Title");
        builder.setContentText("This is the body of Simple notification");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setStyle(bigPictureStyle);
        builder.setPriority(-1);
        builder.addAction(0, "show1", pendingIntent);
        builder.addAction(0, "show2", pendingIntent);
        builder.addAction(0, "show3", pendingIntent);
        builder.addAction(0, "show4", pendingIntent);        // Max 3 only!

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(02, builder.build());
    }

}
