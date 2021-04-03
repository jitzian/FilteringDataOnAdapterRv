package org.com.testing.with.complexsearchrecyclerviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class RVCustomAdapter(private var lstRes: ArrayList<Article>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var lstResFiltered = ArrayList<Article>()

    lateinit var mcontext: Context

    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        lstResFiltered = lstRes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val countryListView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        val sch = CountryHolder(countryListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return lstResFiltered.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Picasso.get()
            .load("https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png")
            .into(holder.itemView.findViewById<ImageView>(R.id.mImageViewCardViewItem))
        holder.itemView.findViewById<TextView>(R.id.mTextViewTitle).text =
            lstResFiltered[position].title
        holder.itemView.findViewById<TextView>(R.id.mTextViewContent).text =
            lstResFiltered[position].content

    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                lstResFiltered = if (charSearch.isEmpty()) {
                    lstRes
                } else {
                    val resultList = ArrayList<Article>()
                    for (row in lstRes) {
                        if (row.title?.toLowerCase(Locale.ROOT)
                                ?.contains(charSearch.toLowerCase(Locale.ROOT)) == true
                        ) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = lstResFiltered
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                lstResFiltered = results?.values as ArrayList<Article>
                notifyDataSetChanged()
            }

        }
    }

}
