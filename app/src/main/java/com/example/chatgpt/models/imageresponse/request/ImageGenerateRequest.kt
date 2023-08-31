package com.example.chatgpt.models.imageresponse.request

data class ImageGenerateRequest(
    val n: Int,
    val prompt: String,
    val size: String
)