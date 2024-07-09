package com.example.foodordering.ui.screen.manager.data

data class Food(
    val id: String,
    val name: String,
    val price: Long,
    val gallery: List<String>,
) {

    constructor() : this(
        getRandomId(),
        getRandomName(),
        getRandOmTotalPrice(),
        getRandomGallery()
    )
}

fun getRandomGallery(): List<String> {
    return listOf(
        "https://example.com/image1.jpg",
        "https://example.com/image2.jpg",
        "https://example.com/image3.jpg"
    )
}

fun getRandomName(): String {
    return listOf(
        "Ratatouille",
        "Paella",
        "Lasagna"
    ).random()
}