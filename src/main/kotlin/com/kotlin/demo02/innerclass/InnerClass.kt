package com.kotlin.demo02.innerclass
class Outter{
    val a:Int = 0
    inner class Inner{
        val b:Int = 5
        fun hello(){
            println("hello ${this@Outter.a}")
        }
    }
}
interface OnClickListener{
    fun onClick()
}
class View{
    var clickListener:OnClickListener?=null
    var c = object : OnClickListener{
        override fun onClick() {
            //TODO("Not yet implemented")
            print("c onClick")
        }

    }
}
fun main() {
    val inner = Outter().Inner()
    inner.hello()
    var view = View()
    view.clickListener = object : OnClickListener{
        override fun onClick() {
            //TODO("Not yet implemented")
            println("匿名内部类")
        }

    }
    view.clickListener?.onClick()
    view.c.onClick()
}