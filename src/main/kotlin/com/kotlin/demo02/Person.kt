package com.kotlin.demo02

abstract  class Person(open val age:Int){
    abstract fun work()
    override fun toString(): String {
        return this::class.simpleName.toString()
    }
}
class Student(override val age:Int):Person(age){
//    override val age:Int
//         get() = 0
    var desc:String = "desc"
        get() = "描述"

    override fun work() {
        //TODO("Not yet implemented")
        println("我是学生在上课")
    }
}
class MaNong(override val age: Int):Person(age) {
    override fun work() {
        //TODO("Not yet implemented")
        println("我是码农在写代码")
    }
}
class Doctor(override val age: Int):Person(age){
    override fun work() {
        //TODO("Not yet implemented")
        println("我是医生正在医治")
    }
}
fun main() {
    var person01:Person = Student(12)
    person01.work()
    println("${person01.age} === ${(person01 as Student).desc}")

    val person02:Person = MaNong(23)
    person02.work()
    println(person02.age)

    val person03:Person = Doctor(24)
    person03.work()
}