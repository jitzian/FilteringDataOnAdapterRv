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
                "Name 1",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name 2",
                "The JPG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name 2",
                "The DWM format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name",
                "The PNG format is widely supported and works best with presentations and web design. "
            ),
            Article(
                "Name 5",
                "The PNG format is widely supported and works best with presentations and web design. "
            )
        )

        combinedData.postValue(Pair(true, lstRes))

    }


}