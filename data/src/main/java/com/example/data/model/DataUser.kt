package com.example.data.model

import android.os.Parcelable
import com.example.domain.model.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataUser(
    val name: String,
    val url : String
) : Parcelable {
    companion object {
        fun toDomain(dataUser: DataUser): User {
            return User(
                name = dataUser.name,
                url = dataUser.url
            )
        }

        fun toData(user: User): DataUser {
            return DataUser(
                name = user.name,
                url = user.url
            )
        }
    }
}
