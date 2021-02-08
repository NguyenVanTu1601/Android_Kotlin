package com.example.coroutine_scope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

/**
 * Một số coroutine_scope :
 * 1. GlobalScope : khi activity/fragment destroy thì nó vẫn sống -> memory leaks. Nó chỉ tắt khi nào ứng dụng tắt
 * 2.lifecycleScope : Chỉ diễn ra khi activity/ fragment còn sống - nhớ bổ sung các thư viện đi kèm
 * 3. viewModelScope : là một scope của viewModel hỗ trợ việc xử lý song song ko bị ARM
 *
 */
class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(CoroutineName("MyScope"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch(Dispatchers.IO) {
            // do nothing
        }

        var MainJob = scope.launch {
            var job1 = launch {
                var x : Int = 0;
                while (isActive){ // khi mà cái corountine này còn hoạt động
                    // ensureActive() // <=> isActive
                    // yield() // nên đọc document của cái này
                    x++;
                    Log.d("Coroutine", "Job1 is running at ${x}...")

                }

            }

            var job2 = launch {
                // do nothing
            }

            delay(1000L) // chạy 1s job1 thì cancel
            job1.cancel()
            job1.join()
            Log.d("Coroutine", "Job1 Cancel...")
        }

        // cancel MainJob thì tất cả dừng
        // còn cancel job1/job2 thì chỉ job đấy dừng
    }


}