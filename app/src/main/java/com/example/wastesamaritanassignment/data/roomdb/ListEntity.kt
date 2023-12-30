package com.example.wastesamaritanassignment.data.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_items")
data class ListEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val quantity:Int,
    val rating:Double,
    val remarks:String,
    val images:List<String>
)