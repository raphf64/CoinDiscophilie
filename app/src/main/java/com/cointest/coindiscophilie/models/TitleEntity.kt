package com.cointest.coindiscophilie.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Title")
data class TitleEntity(

    var albumId: Int = -1,

    @PrimaryKey
    var id: Int = -1,

    var title: String = "",

    var thumbnailUrl: String = "",

    var url: String = ""

)
