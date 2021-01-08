package com.example.my_contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.recycler_view.Example_data

class Display_Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_1)

        val name=findViewById<TextView>(R.id.name)
        val mobile=findViewById<TextView>(R.id.mobile_number)
        val delete=findViewById<TextView>(R.id.delete)
        val edit=findViewById<TextView>(R.id.edit)


        val bundle=intent.extras
        val names=bundle!!.getString("name")
        val mobiles=bundle.getString("mob")
        val position=bundle.getInt("position")

        name.text=names
        mobile.text=mobiles

        delete.setOnClickListener {
            var data=MainActivity()
            MainActivity.datalist.removeAt(position)
            data.adapter?.notifyDataSetChanged()
            Toast.makeText(this, "your contact is deleted", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}