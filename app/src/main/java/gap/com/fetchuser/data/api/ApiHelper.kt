package gap.com.fetchuser.data.api

import gap.com.fetchuser.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}