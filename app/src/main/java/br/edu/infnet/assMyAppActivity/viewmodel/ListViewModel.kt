package br.edu.infnet.assMyAppActivity.viewmodel


import androidx.lifecycle.*
import br.edu.infnet.assMyAppActivity.model.ListEntity
import br.edu.infnet.assMyAppActivity.model.ListRepository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: ListRepository) : ViewModel() {

    val allActivities: LiveData<List<ListEntity>> = repository.allActivities.asLiveData()


    fun insert(listEntity: ListEntity) {  //---Add Item. Acessa o ViewModel Scope para poder acessar o CoroutineScope e assim é possível acessar a base de dados e inserir algo lá
        viewModelScope.launch {
            repository.insert(listEntity)
        }
    }

    fun deleteAll() {    //----Deleta tudo
        viewModelScope.launch {
            repository.deleteAll()
        }
    }


    class ListViewModelFactory(private val repository: ListRepository) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED CAST")
                return ListViewModel(repository) as T
            } else {
                throw IllegalArgumentException("ViewModel não encontrado")
            }
        }
    }

}