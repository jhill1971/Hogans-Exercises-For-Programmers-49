package dev.jameshill.catfetcher.network

class CatResponse {
    //    @Json(name = "tags")
//    var tags = ArrayList<Tags>(),
//    @Json(name = "createdAt")
//    var createdAt: String? = null,
//    @Json(name = "UpdatedAt")
//    var updatedAt: String? = null,
//    @Json(name = "validated")
//    var validated: String? = null,
//    @Json(name = "owner")
//    var owner: String? = null,
//    @Json(name = "file")
//    var file: String? = null,
//    @Json(name = "mimetype")
//    var mimetype: String? = null,
//    @Json(name = "size")
//    var size: Int? = null,
//    @Json(name = "_id")
//    var _id: String? = null,
//    @Json(name = "url")
    var url: String? = null
}

class Tags() {
    var tags = ArrayList<String>()
}

