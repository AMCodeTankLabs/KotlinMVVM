package com.codetanklabs.advancedkotlin.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.codetanklabs.advancedkotlin.R
import com.codetanklabs.advancedkotlin.model.User

class UserListAdapter(context: Context, resource: Int, list: List<User>) :
        ArrayAdapter<User>(context, resource, list) {

    var resource: Int
    var list: List<User>
    var vi: LayoutInflater

    init {
        this.resource = resource
        this.list = list
        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        var holder: ViewHolder
        var retView: View

        if(convertView == null){
            retView = vi.inflate(resource, null)
            holder = ViewHolder()

            holder.firstName = retView.findViewById(R.id.txt_firstName)
            holder.lastName = retView.findViewById(R.id.txt_lastName)
            holder.company = retView.findViewById(R.id.txt_company)
            holder.email = retView.findViewById(R.id.txt_email)

            holder.firstName?.text = list[position].firstName
            holder.lastName?.text = list[position].lastName
            holder.company?.text = list[position].company
            holder.email?.text = list[position].email

        } else {
            retView = convertView
        }

        return retView
    }

    internal class ViewHolder {
        var firstName: TextView? = null
        var lastName: TextView? = null
        var company: TextView? = null
        var email: TextView? = null
    }

}
