package com.example.mediunalbum

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform