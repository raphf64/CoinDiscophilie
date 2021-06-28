package com.cointest.coindiscophilie.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cointest.coindiscophilie.viewmodels.DiscItemViewModel


@Entity(tableName = "Title")
data class TitleEntity(

    var albumId: Int = -1,

    @PrimaryKey
    var id: Int = -1,

    var title: String = "",

    var thumbnailUrl: String = "",

    var url: String = ""

){
    fun toViewModel() = DiscItemViewModel(title,id,albumId,thumbnailUrl,url)
}
