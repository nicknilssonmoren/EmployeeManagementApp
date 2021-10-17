package com.example.projekt

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "MyDB"
const val TABLE_NAME = "Users"
const val COL_NAME = "name"
const val COL_AGE = "age"
const val COL_ID = "id"

// Cursor factory = if not using pass NULL
class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        // No DB - Then create
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME VARCHAR(256), " +
                "$COL_AGE INTEGER)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user : User) {
        val db = this.writableDatabase                 // Write to DB
        val cv = ContentValues()                       // Value of Content
        cv.put(COL_NAME, user.name)                    // PUT column name, User.name
        cv.put(COL_AGE, user.age)                      // PUT column age, User.age

        val result = db.insert(TABLE_NAME, null, cv)

        if (result == (0).toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }


    @SuppressLint("Range")
    fun readData() : MutableList<User> {
        val list: MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
                list.add(user)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteData(id:Int){
        val db = this.readableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME WHERE id=$id")
        db.close()
    }

    fun updateDataColName(id:Int, name:String){
        val db = this.readableDatabase
        db.execSQL("UPDATE $TABLE_NAME SET $COL_NAME = '$name' WHERE id=$id")
        db.close()
    }

    fun updateDataColAge(id:Int, age:Int){
        val db = this.readableDatabase
        db.execSQL("UPDATE $TABLE_NAME SET $COL_AGE = $age WHERE id=$id")
        db.close()
    }

}
