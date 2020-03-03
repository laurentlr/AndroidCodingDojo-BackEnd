package data

import domain.Action
import domain.User
import java.net.URI

class DataBase {

    companion object {
        val users = mutableListOf<User>(
                User(name = "Laurent", avatar = URI.create("https://media-exp1.licdn.com/dms/image/C5103AQH58lhNws5dyQ/profile-displayphoto-shrink_200_200/0?e=1587600000&v=beta&t=W1qUktel1n5S-Yx6mVst26lbnozGCZwniwE6aXLWtnU")),
                User(name = "Sylvain", avatar = URI.create("https://media-exp1.licdn.com/dms/image/C5603AQFeU3E89H96fQ/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=GvgLI1WhQSyxZo8K1UMuNOmofHzJCgUb_eYvy_BXWgg"))
        )

        val actions = mutableListOf<Action>()

        val fcmTokens = mutableListOf<String>()
    }
}