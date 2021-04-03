package org.com.testing.with.complexsearchrecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import org.com.testing.with.complexsearchrecyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RVCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSearchView()
        initRV()
    }

    private fun initRV() {
        adapter = RVCustomAdapter(getData() as ArrayList<Article>)
        binding.mRecyclerViewMainArticles.adapter = adapter
    }

    private fun initSearchView() {
        binding.mSearchViewMainActivity.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun getData() =
        mutableListOf(
            Article(
                "Darinka",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Ana Darinka Fernandez Mosqueda",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Ulises Fernandez Mosqueda",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Hector Lucio Mosqueda",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Victoria Nicole Lucio Mosqueda",
                "The PNG format is widely supported and works best with presentations and web design. "
            )
        )
}