package com.kengwang.caferss

import com.google.gson.Gson

data class UserLoginCallback(
    val md5: String,
    val password: Any,
    val username: Any
)

class UserUtils {
    companion object {
        fun Login(username: String, password: String) :Boolean {
            val callback: String = HttpUtil.httpPost(
                "http://192.168.0.102/api.php",
                mapOf("username" to username, "password" to password)
            )
            //println(callback)
            val result = Gson().fromJson(callback, UserLoginCallback::class.javaObjectType)
            return result.username == username
        }
    }
}
