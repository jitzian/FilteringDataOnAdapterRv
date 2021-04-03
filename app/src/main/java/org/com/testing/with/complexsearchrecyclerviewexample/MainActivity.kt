package org.com.testing.with.complexsearchrecyclerviewexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import org.com.testing.with.complexsearchrecyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RVCustomAdapter
    private val vm by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSearchView()
        vm.fetchData()
        setupObservers()

    }

    private fun setupObservers() {
        vm.combinedData.observe(this, Observer { data ->
            if (data.first) {
                adapter = RVCustomAdapter(data.second as ArrayList<Article>)
                binding.mRecyclerViewMainArticles.adapter = adapter
            } else {
                Log.e(TAG, "setupObservers::NO DATA")
            }
        })
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

}