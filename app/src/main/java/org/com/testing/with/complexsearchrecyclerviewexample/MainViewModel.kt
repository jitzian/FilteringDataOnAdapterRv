package org.com.testing.with.complexsearchrecyclerviewexample

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    var combinedData = MediatorLiveData<Pair<Boolean, List<Article>>>()
    fun fetchData() = viewModelScope.launch(Dispatchers.IO) {

        val lstRes = mutableListOf(
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

        combinedData.postValue(Pair(true, lstRes))

    }


}