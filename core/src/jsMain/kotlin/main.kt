//import com.jfs.core.Greeting


@ExperimentalJsExport
fun main() {
    //console.log(Greeting().commonGreeting() + "Test this")
}

@ExperimentalJsExport
@JsExport
@JsName("TestThisTwo")
fun testThis(): Int {
    return 1
}