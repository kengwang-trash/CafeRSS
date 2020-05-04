package com.kengwang.caferss

import android.os.Bundle
import android.view.View
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.UI
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbutton.setOnClickListener {
            loginbutton.visibility = View.GONE
            progress.visibility = View.VISIBLE
            Thread {
                val result: Boolean = UserUtils.Login(
                    username.text.toString(),
                    password.text.toString()
                )
                runOnUiThread {
                    this.onLoginResult(
                        result
                    )
                }
            }.start()
        }
    }

    private fun onLoginResult(result: Boolean) {
        if (result) {
            toast("登录成功")
            progress.visibility=View.GONE
            startActivity<HomeActivity>()
        } else {
            toast("登录失败")
        }
    }

}
