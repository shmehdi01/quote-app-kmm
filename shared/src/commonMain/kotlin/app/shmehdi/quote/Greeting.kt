package app.shmehdi.quote

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}