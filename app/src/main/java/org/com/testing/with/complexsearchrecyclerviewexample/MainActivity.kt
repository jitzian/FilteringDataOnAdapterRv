package org.com.testing.with.complexsearchrecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.com.testing.with.complexsearchrecyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RVCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRV()
    }

    private fun initRV() {
        adapter = RVCustomAdapter(getData())
        binding.mRecyclerViewMainArticles.adapter = adapter
    }

    private fun getData() =
        mutableListOf(
            Article(
                "Important Title 1",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Important Title 2",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Important Title 3",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Important Title 4",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Important Title 5",
                "The PNG format is widely supported and works best with presentations and web design. "
            )
        )
}