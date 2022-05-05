package com.example.myapplicationcleanremote.model

import android.os.Parcelable
import com.example.domain.model.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class PresentationUser(
    var name: String,
    var url: String
) : Parcelable {
    companion object {
        fun toDomain(presentationUser: PresentationUser): User {
            return User(
                name = presentationUser.name,
                url = presentationUser.url
            )
        }

        fun toPresentation(user: User): PresentationUser {
            return PresentationUser(
                name = user.name,
                url = user.url
            )
        }
    }
}
