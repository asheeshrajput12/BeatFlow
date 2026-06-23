package com.asheesh.beatflow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform