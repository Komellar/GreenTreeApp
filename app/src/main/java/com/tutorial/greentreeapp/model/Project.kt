package com.tutorial.greentreeapp.model

import java.io.Serializable

data class Project (
    val id: Int,
    val imageResourceId: Int,
    val rating: String,
    val description: String
) : Serializable
