package com.example.paginglibrarytest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity(tableName = "item")
data class Item(
    @field:SerializedName("git_url") var git_url: String,
    @field:SerializedName("html_url") var html_url: String,
    @field:SerializedName("name") var name: String,
    @field:SerializedName("path") var path: String,
    @field:SerializedName("repository") var repository: Repository,
    @field:SerializedName("score") var score: Double,
    @PrimaryKey @field:SerializedName("sha") var sha: String,
    @field:SerializedName("url") var url: String
){
    constructor() : this("","","","",
        Repository("","","","","","","","","","","","","","",false,"","","","","","","",0,"","","","","","","","","","","",
            Owner(
                "","","","","","","",0,"","","","","",false,"","","",""
            ),false,"","","","","","","","","",""),
        0.0,"","")
}


class RepositoryPersistentConverter{
    @TypeConverter
    fun storeRepositoryToString(data: Repository): String = Gson().toJson(data)

    @TypeConverter
    fun storeStringToRepository(value: String) : Repository = Gson().fromJson(value, Repository::class.java)
}
class OwnerPersistentConverter{
    @TypeConverter
    fun storeOwnerToString(data: Owner): String = Gson().toJson(data)

    @TypeConverter
    fun storeStringToOwner(value: String) : Owner = Gson().fromJson(value, Owner::class.java)
}