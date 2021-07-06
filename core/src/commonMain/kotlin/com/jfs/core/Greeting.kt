package com.jfs.core

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName


@ExperimentalJsExport
@JsExport
@JsName("Greeting")
class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun commonGreeting(): String {
        return "Wassssssaaaaaaapp"
    }
}