package gap.com.fetchuser.data.api

import gap.com.fetchuser.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : Response<List<User>>
}