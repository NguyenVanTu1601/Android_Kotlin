package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.MyAdapter
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Nhớ thêm 'kotlin-android-extensions' vào file build.gradle để gọi được nhanh các view mà ko cần findViewById
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy{MyAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //get
        getPost()

        // post
        var post = Post(2,2,"Tú Nguyễn", "Android Developer")
        pushPost(post)
        //pushPost2(2,2,"Tú Nguyễn","Android developer")
    }

    private fun setUpRecyclerView(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getPost(){
        var options : HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"
        viewModel.getCustomPostByMap(2, options)
        viewModel.myCustomPosts.observe(this, Observer {
            response ->
            if (response.isSuccessful){
                //Log.d("Response", response.body()?.title.toString())
                //response.body()?.forEach{it -> } dùng khi respone trả về là 1 list chẳng hàng myCustomPost
                response.body()?.let {
                    myAdapter.setData(it)
                }
            }else{
                Log.d("Response", response.errorBody().toString())
            }

        })
    }

    private fun pushPost(post : Post){
        viewModel.pushPost(post)
        viewModel.myResponse.observe(this, Observer {
            Log.d("Response", it.body()?.toString())
            Log.d("Response", it.headers().toString())
        })
    }

    private fun pushPost2(userId:Int, id:Int, title:String, body:String){
        viewModel.pushPost2(userId,id,title,body)
        viewModel.myResponse.observe(this, Observer {
            Log.d("Response", it.body()?.toString())
            Log.d("Response", it.code().toString())
            Log.d("Response", it.headers().toString())
        })
    }
}