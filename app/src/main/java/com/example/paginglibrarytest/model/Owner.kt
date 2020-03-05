package com.example.paginglibrarytest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "owner")
data class Owner(
    @field:SerializedName("avatar_url") var avatar_url: String,
    @field:SerializedName("events_url") var events_url: String,
    @field:SerializedName("followers_url") var followers_url: String,
    @field:SerializedName("following_url") var following_url: String,
    @field:SerializedName("gists_url") var gists_url: String,
    @field:SerializedName("gravatar_id") var gravatar_id: String,
    @field:SerializedName("html_url") var html_url: String,
    @PrimaryKey @field:SerializedName("id") var id: Int,
    @field:SerializedName("login") var login: String,
    @field:SerializedName("node_id") var node_id: String,
    @field:SerializedName("organizations_url") var organizations_url: String,
    @field:SerializedName("received_events_url") var received_events_url: String,
    @field:SerializedName("repos_url") var repos_url: String,
    @field:SerializedName("site_admin") var site_admin: Boolean,
    @field:SerializedName("starred_url") var starred_url: String,
    @field:SerializedName("subscriptions_url") var subscriptions_url: String,
    @field:SerializedName("type") var type: String,
    @field:SerializedName("url") var url: String
){
    constructor(): this("","","","","","","",0,"","","","","",false,"","","","")
}