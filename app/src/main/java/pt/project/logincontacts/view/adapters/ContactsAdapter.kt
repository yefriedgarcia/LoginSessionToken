package pt.project.logincontacts.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.project.crm_pruebatecnica.dtos.auth.AuthDetails
import pt.project.logincontacts.R
import pt.project.logincontacts.databinding.CardviewContactsBinding
import pt.project.logincontacts.dtos.contacts_model.Result

class ContactsAdapter(val contacstDetails: List<Result>): RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater: LayoutInflater= LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.cardview_contacts, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact =  contacstDetails[position]
        holder.bind(contact)

    }

    override fun getItemCount(): Int {
        return if(contacstDetails.size > 0){
            contacstDetails.size
        }else{
            0
        }

    }


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = CardviewContactsBinding.bind(itemView)

        fun bind(contact: Result){
            binding.apply {
                contactNo.text = contact.contact_no
                title.text = contact.email
            }
        }
    }
}