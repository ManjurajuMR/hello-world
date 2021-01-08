package com.example.my_contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.ContactsRecyclerviewAdapter
import com.example.recycler_view.Example_data

class MainActivity : AppCompatActivity() {

        companion object {
            var datalist = ArrayList<Example_data>()
    }
     var adapter: ContactsRecyclerviewAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRecyclerview()
        val newcontact=findViewById<Button>(R.id.newcontact)

        newcontact.setOnClickListener {
            val intent= Intent(this,Add_Contact::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun initializeRecyclerview(){
       /* datalist.add(Example_data("manju","7026988394"))
        datalist.add(Example_data("darsu","9505881181"))
        datalist.add(Example_data("punith","8884884360"))*/
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        adapter=ContactsRecyclerviewAdapter(datalist)
        recyclerView.adapter=adapter
    }
}

