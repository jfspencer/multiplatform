package com.jfs.core

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}