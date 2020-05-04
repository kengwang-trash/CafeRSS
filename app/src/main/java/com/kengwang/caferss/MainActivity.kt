package com.kengwang.caferss

import android.database.Cursor
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Load Database
        userDatabase.use {
            val c: Cursor =  query("user", null, null, null, null, null, null)
            if (c.count==0){//unInitialized
                button1.visibility = View.VISIBLE
                c.close()
                button1.setOnClickListener { startActivity<LoginActivity>() }
            }else{
                progress.visibility=View.VISIBLE
                startActivity<HomeActivity>()
            }
        }

    }
}
