package com.example.my_contacts

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.recycler_view.Example_data
import java.util.jar.Manifest


class Add_Contact : AppCompatActivity() {
    private var imageView: ImageView? = null
    val Request_code = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__contact)

        val name=findViewById<TextView>(R.id.addname)
        val mobile=findViewById<TextView>(R.id.addmobile_number)
        val add_btn=findViewById<Button>(R.id.add_btn)
        val add_image=findViewById<Button>(R.id.add_image)
        imageView = findViewById<ImageView>(R.id.photo)

        add_btn.setOnClickListener {
            val names=name.text.toString()
            val mobiles=mobile.text.toString()
            var data=MainActivity()
            MainActivity.datalist.add(Example_data(names, mobiles))
            data.adapter?.notifyDataSetChanged()
            Toast.makeText(this, "your contact is added", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        add_image.setOnClickListener {
          val imageintent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if(imageintent.resolveActivity(this.packageManager)!=null){
                startActivityForResult(imageintent,Request_code)
            }else{
                Toast.makeText(this, "not posible to take pics", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==Request_code && resultCode==Activity.RESULT_OK){
            val takeimage=data?.extras?.get("data")as Bitmap
            imageView?.setImageBitmap(takeimage)
        }else{
            super.onActivityResult(requestCode, resultCode, data)

        }
    }

}