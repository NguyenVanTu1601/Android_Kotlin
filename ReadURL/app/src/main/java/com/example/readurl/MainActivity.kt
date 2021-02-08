package com.example.readurl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ReadURL().execute("https://khoapham.vn/")

        ReadImage().execute("https://kenh14cdn.com/thumb_w/660/2020/6/5/006mrmprly1gdx6exf3lyj30u01rcasm-" +
                "15913263980501789002707-crop-15913264120321997228444.jpg")
    }

    inner class ReadURL : AsyncTask<String, Void, String>(){

        override fun doInBackground(vararg params: String?): String {
            var content : StringBuilder = StringBuilder()
            var url : URL = URL(params[0])
            val urlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
            var inputStream : InputStream = urlConnection.inputStream
            var inputStreamReader : InputStreamReader = InputStreamReader(inputStream)
            val buffredReader : BufferedReader = BufferedReader(inputStreamReader)
            var line : String = ""
            try {
                while (buffredReader.readLine()!= null){
                    line = buffredReader.readLine()
                    content.append(line + "\n")
                }
                buffredReader.close()
                inputStreamReader.close()
                inputStream.close()
            }catch (e : Exception){

            }
            return content.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txtContent.text = result
        }
    }

    inner class ReadImage : AsyncTask<String, Void, Bitmap>(){
        override fun doInBackground(vararg params: String?): Bitmap {
            var url = URL(params[0])
            val inputStream : InputStream = url.openConnection().getInputStream()
            val bitmap : Bitmap = BitmapFactory.decodeStream(inputStream)

            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageView.setImageBitmap(result)
        }
    }
}