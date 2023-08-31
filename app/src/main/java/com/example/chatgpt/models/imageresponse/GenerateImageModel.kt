package com.example.chatgpt.models.imageresponse

data class GenerateImageModel(
    val created: Int,
    val `data`: List<Data>
)