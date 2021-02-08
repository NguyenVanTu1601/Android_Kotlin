package com.example.json_object

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var urlObject : String = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json"
        var urlArray : String = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json"

        JSON_Oject().execute(urlObject)
        JSON_Array(urlArray)

    }

    inner class JSON_Oject : AsyncTask<String,Void,String>(){
        override fun doInBackground(vararg params: String?): String {
            var url : URL = URL(params[0])
            var content : StringBuilder = StringBuilder()

            var urlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection
            val inputStreamReader : InputStreamReader = InputStreamReader(urlConnection.inputStream)
            val bufferedReader : BufferedReader = BufferedReader(inputStreamReader)
            var line : String = ""
            try {
                do{
                    line = bufferedReader.readLine()
                    if(line != null){
                        content.append(line)
                    }
                }while (line != null)

                bufferedReader.close()
                inputStreamReader.close()
            }catch (e : Exception){

            }

            return content.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val objectInfo : JSONObject = JSONObject(result)
            val monhoc : String = objectInfo.getString("monhoc")
            val noihoc : String = objectInfo.getString("noihoc")
            val website : String = objectInfo.getString("website")
            val fanpage : String = objectInfo.getString("fanpage")
            val logo : String = objectInfo.getString("logo")

            txtJsonObject.text = monhoc + "\n"
            txtJsonObject.append(noihoc + "\n")
            txtJsonObject.append(website + "\n")
            txtJsonObject.append(fanpage + "\n")
            txtJsonObject.append(logo + "\n")

        }

    }

    fun JSON_Array(urlArray : String){
        var url : String? = urlArray

        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap

        val network = BasicNetwork(HurlStack())

        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    var objectInfo : JSONObject = JSONObject(response)
                    var arrayInfo : JSONArray = objectInfo.getJSONArray("danhsach")

                    var  course : String = ""
                    txtJsonArray.append("\n")
                    for (item in 0 until arrayInfo.length()){
                        var itemObject : JSONObject = arrayInfo.getJSONObject(item)
                        course = itemObject.getString("khoahoc")
                        txtJsonArray.append(course + "\n")
                    }

                },
                Response.ErrorListener { error ->
                    txtJsonArray.text = "Error loading data..."
                })

        requestQueue.add(stringRequest)
    }
}