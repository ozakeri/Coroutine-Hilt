package gap.com.fetchuser.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gap.com.fetchuser.data.model.User
import gap.com.fetchuser.data.repository.MainRepository
import gap.com.fetchuser.utils.NetworkHelper
import gap.com.fetchuser.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val users = MutableLiveData<Resource<List<User>>>()
    val userList: LiveData<Resource<List<User>>>
        get() = users

    init {
        fetchUsers()
    }

    fun fetchUsers(){
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                mainRepository.getUsers().let {
                    if (it.isSuccessful){
                        users.postValue(Resource.success(it.body()))
                    }else users.postValue(Resource.error(it.message().toString(),null))
                }
            }else users.postValue(Resource.error("No Internet",null))
        }
    }

}