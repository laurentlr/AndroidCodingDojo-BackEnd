package domain

import java.util.*

data class Action(
        val id: String,
        val description: String,
        val owner: User,
        val creationDate: Date,
        val dueDate: Date?
)