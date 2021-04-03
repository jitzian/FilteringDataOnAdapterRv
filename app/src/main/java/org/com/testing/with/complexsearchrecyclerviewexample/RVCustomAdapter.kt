package org.com.testing.with.complexsearchrecyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RVCustomAdapter(var lstRes: List<Article>?) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lstRes?.get(position)?.let { holder.bindDta(it) }
    }

    override fun getItemCount(): Int {
        return lstRes?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mImageViewCardViewItem: ImageView =
            itemView.findViewById(R.id.mImageViewCardViewItem)
        private val mTextViewTitle: TextView = itemView.findViewById(R.id.mTextViewTitle)
        private val mTextViewContent: TextView = itemView.findViewById(R.id.mTextViewContent)

        fun bindDta(data: Article) {
            Picasso.get()
                .load("https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png")
                .into(mImageViewCardViewItem)

            mTextViewTitle.text = data.title
            mTextViewContent.text = data.content
        }

    }


}