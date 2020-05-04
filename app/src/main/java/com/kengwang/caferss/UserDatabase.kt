package com.kengwang.caferss

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import org.jetbrains.anko.db.*

class UserDatabase(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "user", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            "user", true,
            Pair("username", TEXT),
            Pair("password", TEXT),
            Pair("session", TEXT),
            Pair("logintime", INTEGER)
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}

val Context.userDatabase: UserDatabase
    //为上下文创建一个扩展属性，这样任何需要Context的类都可以直接访问数据库。
    get() = UserDatabase(applicationContext.applicationContext)

