package ru.h1n.httpmy_crazy_project_more20more.more20more;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

public class Seach_new_Datas extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationManager mNotificationManager1 =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel channel1 = new NotificationChannel("app_channel",
                "Уведомления денег",
                NotificationManager.IMPORTANCE_DEFAULT);
        mNotificationManager1.createNotificationChannel(channel1);



        Intent intentNotify = new Intent(this, Notify_new_Datas.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intentNotify, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmForNotification = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar c = Calendar.getInstance();

        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 21, 0, 0);

        if(System.currentTimeMillis() > c.getTimeInMillis()) c.add(Calendar.DATE, 1);

        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) c.add(Calendar.DATE, 2);
        else if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) c.add(Calendar.DATE, 1);

        alarmForNotification.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setChannelId("app_channel")
                        .setWhen(0)
                        .setPriority(Notification.PRIORITY_MIN);

        startForeground(1, mBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
