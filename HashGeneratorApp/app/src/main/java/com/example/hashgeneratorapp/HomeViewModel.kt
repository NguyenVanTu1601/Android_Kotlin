package com.example.hashgeneratorapp

import androidx.lifecycle.ViewModel
import java.security.MessageDigest

class HomeViewModel : ViewModel() {
    fun getHash(plainText : String, algorithm : String) : String{
        val bytes = MessageDigest.getInstance(algorithm).digest(plainText.toByteArray())
        return toHex(bytes)
    }

    private fun toHex(bytes : ByteArray) : String{
        return bytes.joinToString("") {
            "%02x".format(it)//  xem thêm trên javaTPoint %x - Hex String
                            // 02 là tách theo 2 chữ số (nếu bỏ cái () của jointoString đi)
                            // và cho phép kiểu 05, nếu ko có số 0 nó sẽ chỉ là 5
        }
    }
}