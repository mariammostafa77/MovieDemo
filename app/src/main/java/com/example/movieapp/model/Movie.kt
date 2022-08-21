package com.example.movieapp.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.io.Serializable

data class Movie (
    var category: String?=null,
    var imageUrl: String?=null,
    var name: String?=null,
    var desc: String?=null
    ) : Serializable
