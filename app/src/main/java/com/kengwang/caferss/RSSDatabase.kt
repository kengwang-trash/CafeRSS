package com.kengwang.caferss

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import org.jetbrains.anko.db.*

class RSSDatabase(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "rss", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            "feeds", true,
            Pair("id", INTEGER + PRIMARY_KEY + AUTOINCREMENT),
            Pair("name", TEXT),
            Pair("description", TEXT),
            Pair("groupid", INTEGER),
            Pair("feedlink", TEXT),
            Pair("avatar", TEXT)
        )
        db?.insert(
            "feeds",
            Pair("name", "少数派"),
            Pair("description", "少数派致力于更好地运用数字产品或科学方法，帮助用户提升工作效率和生活品质"),
            Pair("groupid",0),
            Pair("feedlink","https://sspai.com/feed"),
            Pair("avatar","https://cdn.sspai.com/sspai/assets/img/favicon/icon.ico")
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}

val Context.rssdatabase: RSSDatabase
    //为上下文创建一个扩展属性，这样任何需要Context的类都可以直接访问数据库。
    get() = RSSDatabase(applicationContext.applicationContext)

