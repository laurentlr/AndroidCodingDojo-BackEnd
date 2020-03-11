package domain

import java.util.*

data class Action(
        val id: String = UUID.randomUUID().toString(),
        val description: String,
        val userId: String?
)