package idv.fanboat.saveme.view

interface NavigatorInterface {
    fun createNewPage(actionId: Int)
    fun pushPage(actionId: Int)
    fun popPage()
}