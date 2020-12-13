package com.kotlin.demo02.dataclass

data class Country(val id:Int,val name:String)
class ComponentX{
    operator fun component1():String{
        return "hello "
    }
    operator fun component2():Int{
        return 0
    }
    operator fun component3():Int{
        return 2
    }
    operator fun component4():Int{
        return 1
    }
    operator fun component5():Int{
        return 5
    }
}
fun main() {
    val china = Country(0,"中国")
    println(china)
    println("china.component1() = " + china.component1())
    println("china.component1() = ${china.component2()}")
    val(id,name) = china
    println("id = " + id)
    println("name = " + name)

    val componentX = ComponentX()
    val(a,b,c,d) = componentX
    println("$a,$b,$c,$d")
    var(e,f,g,h,i) = componentX
    println("$e,$f,$g,$h,$i")
}