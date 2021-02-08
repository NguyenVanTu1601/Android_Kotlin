package com.example.scope_function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * let, run, with, also, apply
 * Trong đó : apply, also return ra 1 context object
 * let, run, with return một lambda result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var person = Person("Nguyễn Văn Tú","0365882920","Hưng Hà, Thái Bình", 21)

        // mặc định trong let là it, nếu ko muốn có thể đổi
        person.let { user ->
            if (user.name != null){
                user.changePhone("0345023705")
                user.moveAddress("Hồng An, Hưng Hà, Thái Bình")
            }

            user.displyInfo()
        }

        // run
        // run cũng giống let, tuy nhiên thay vì trả về it như let, run sẽ trả về this - chính là đối tượng mình tác đông
        // run tương tác trực tiếp với object mình truyền vô
        person.run {
            changePhone("0345023705")
            moveAddress("Hồng An, Hưng Hà, Thái Bình")
            displyInfo()
        }

        //with
        with(person){
            changePhone("0387478518")
            moveAddress("Hà Nội")
            println(displyInfo())
        }

        // apply
        var user = Person(
            name = "Nguyễn Văn Tú",
            phone = "0345023569",
            address = "Hà Nội",
            age = 22)
            .apply {
                println(displyInfo())
            }
    }
}