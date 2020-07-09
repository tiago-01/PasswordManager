package com.ipca.passwordmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<AppListAdapter.AppViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var apps = emptyList<App>() // Cached copy of words

    inner class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appItemView: TextView = itemView.findViewById(R.id.textView)
        val appEmailView: TextView = itemView.findViewById(R.id.textViewEmail)
        val appPasswordView: TextView = itemView.findViewById(R.id.textViewPassword)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return AppViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val current = apps[position]
        holder.appItemView.text = current.appname
        holder.appEmailView.text = current.email
        holder.appPasswordView.text = current.password

    }

    internal fun setApps(apps: List<App>) {
        this.apps = apps
        notifyDataSetChanged()
    }

    override fun getItemCount() = apps.size
}


