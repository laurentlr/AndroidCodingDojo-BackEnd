package domain

import java.net.URI
import java.util.*

data class User(
        val id: String = UUID.randomUUID().toString(),
        val name: String,
        val avatar: URI? = null
)
