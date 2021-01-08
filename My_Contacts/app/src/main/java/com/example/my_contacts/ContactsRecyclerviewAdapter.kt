package com.example.recycler_view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_contacts.Display_Activity1
import com.example.my_contacts.MainActivity
import com.example.my_contacts.R

class ContactsRecyclerviewAdapter(private val mContactslist: ArrayList<Example_data>,):RecyclerView.Adapter<ContactsRecyclerviewAdapter.ContactviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactviewHolder {
       val inflater=LayoutInflater.from(parent.context)
        return ContactviewHolder(inflater.inflate(R.layout.layout_contacts, parent, false))
    }

    override fun onBindViewHolder(holder: ContactviewHolder, position: Int) {
        mContactslist.sortWith(compareBy { it.name })
        var nContactlist=mContactslist[position]
        holder.name.text=nContactlist.name
        holder.name2.text=nContactlist.mob_no
        holder.itemView.setOnClickListener{
            var data=mContactslist[position]
            var position=holder.adapterPosition
            val intent=Intent(it.context,Display_Activity1::class.java)
            intent.putExtra("name",data.name)
            intent.putExtra("mob",data.mob_no)
            intent.putExtra("position",position)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return mContactslist.size
    }

   class ContactviewHolder(item:View):RecyclerView.ViewHolder(item){
        var name=item.findViewById<TextView>(R.id.name)
        var name2=item.findViewById<TextView>(R.id.mob_no)

    }

}








