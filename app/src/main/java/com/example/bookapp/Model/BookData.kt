package com.example.bookapp.Model

import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("items"      ) var books      : ArrayList<Book> = arrayListOf()

)
data class Book (

    @SerializedName("id"         ) var id         : String?     = null,
    @SerializedName("selfLink"   ) var selfLink   : String?     = null,
    @SerializedName("volumeInfo" ) var volumeInfo : VolumeInfo? = VolumeInfo(),

)


data class VolumeInfo (

    @SerializedName("title"               ) var title               : String?                        = null,
    @SerializedName("authors"             ) var authors             : ArrayList<String>              = arrayListOf(),
    @SerializedName("publisher"           ) var publisher           : String?                        = null,
    @SerializedName("publishedDate"       ) var publishedDate       : String?                        = null,
    @SerializedName("description"         ) var description         : String?                        = null,
    @SerializedName("imageLinks"          ) var imageLinks          : ImageLinks?                    = ImageLinks(),


)
data class ImageLinks (

    @SerializedName("smallThumbnail" ) var smallThumbnail : String? = null,
    @SerializedName("thumbnail"      ) var thumbnail      : String? = null

)