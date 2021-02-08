package com.example.notification

import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*


/**
 * https://viblo.asia/p/tao-mot-notification-trong-android-YWOZr0Vr5Q0
 * Có 1 phần hay là trả lời trực tiếp từ notifi nhưng ngại chưa học
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var channelID : String = "com.example.notification" // yêu cầu bắt buộc với android 8 api > 26
        var notificationId : Int = 1999


        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, MainActivity::class.java) // mở màn hình MainActivity
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


        // create Channel
        createNotificationChannel(channelID, "NotifyDemo","Example News Channel")

        // create Notification
        var mBuilder : NotificationCompat.Builder = NotificationCompat.Builder(this, channelID)
        with(mBuilder){
            setSmallIcon(R.mipmap.ic_launcher) // small icon
            setContentTitle("Hello") // title
            setContentText("Wellcome to kotlin") // body
            setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line...")) // style when text long
            setPriority(NotificationCompat.PRIORITY_HIGH) // property

            // set action user click
            setContentIntent(pendingIntent)
            setAutoCancel(true) // close notify when user click
            setTimeoutAfter(6000) //close notify after timeout

            // icon
            addAction(R.mipmap.ic_launcher_round,"Go to app", pendingIntent) // icon button, titleButton
        }


        // on click btn
        sendNotification.setOnClickListener {
            val notificationManager =
                NotificationManagerCompat.from(this)
            notificationManager.notify(notificationId, mBuilder.build())
        }
    }


    // với android 8 trở lên cần đăng ký một channel trước khi tạo notification
    fun createNotificationChannel(id: String, name: String,
                                  description: String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var importance = NotificationManager.IMPORTANCE_DEFAULT
            var channel : NotificationChannel = NotificationChannel(id, name, importance)
            channel.description = description
            channel.lightColor = Color.RED
            channel.enableLights(true)
            channel.enableVibration(true)

            var notificationManager : NotificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

}