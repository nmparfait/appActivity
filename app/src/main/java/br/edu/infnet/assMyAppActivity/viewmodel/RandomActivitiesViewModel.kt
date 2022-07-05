package br.edu.infnet.assMyAppActivity.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.assMyAppActivity.model.activitiesListApp


class RandomActivitiesViewModel : ViewModel() {


    private val _thought = MutableLiveData<String>()
    val activities: LiveData<String>
        get() = _thought


    fun randomList() {
        _thought.value = activitiesListApp.random()
    }

    init {
        randomList()
    }
}