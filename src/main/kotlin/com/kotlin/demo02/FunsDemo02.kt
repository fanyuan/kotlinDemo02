package com.kotlin.demo02

import jdk.jfr.events.FileReadEvent
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * 遍历函数
 */
fun forEachTest(){
    val list = listOf(1,2,3,4,5,6)
    val newList = ArrayList<Int>()
    list.forEach{
        val newItem = it * 2 + 3
        newList.add(newItem)
    }
    println(newList)
}
/**
 * 对集合每一个元素做变换
 */
fun mapTest(){
    val list = listOf(1,2,3,4,5,6)
    val newList = list.map {
        it * 2 + 3
    }
    println("newList = " + newList)
    val newList2 = list.map {
        it.toDouble()
    }
    println("newList2 = " + newList2)
}
/**
 * 对数组中每个元素变化，铺平后，装进一个新的集合
 */
fun flatMapTest(){
    val list = listOf(1,2,3,4,5,6)
    val newList = ArrayList<Int>()
    println(list)
    list.flatMap {
        //println("flatMap it = $it")
        newList.add(it * 3 + 2)
        newList
    }
    println(newList)
}
/**
 * 从集合左到右，依次计算每个元素累加的结果。
 */
fun reduceTest(){
    println("=== reduceTest ===")
    val list = listOf(1,2,3,4,5,6)
    list.reduce { acc, i ->
        println("acc = $acc --- i = $i")
        acc + i
    }
    println(list.reduce { acc, i -> acc + i  })
    val array = arrayOf(1,2,3,4,5,6)
    println(Arrays.toString(array))
    println(array.reduce { acc, i -> acc + i  })
}
fun findPerson():Person?{
    val num = Random().nextInt(3)
    when(num){
        0 -> {
             //println("num = $num")
             return Student(12)
        }
        1 -> {
            //println ("num = $num")
            return MaNong(23)
        }
        2 -> {
            //println("num = $num")
            return Doctor(25)
        }
        else -> {
            println(" else num = $num")
            return null
        }
    }
    //return null
}

/**
 * also apply 都不返回闭包执行结果,返回的是this（调用者），区别在于also有闭包参数，apply没有
 */
fun applyTest(){
    findPerson()?.apply {
        work()
        println("age = $age")
    }
}

/**
 * with可以让用户省略点号之前的对象引用，with内部的所有操作都是针对with对象
 */
fun withTest(){
    var p = findPerson()
    var result = with(p){
        this?.work()
        println(this?.age)
        100
    }
    println("withTest result = $result")
}

/**
 * let 和run 都会返回闭包执行结果，区别在于let有闭包参数，run没有
 */
fun letTest(){
    var result = findPerson()?.let {
        it.work()
        println(it.age)
        "10 abc"
    }
    println("letTest result = $result")
}

/**
 * let 和run 都会返回闭包执行结果，区别在于let有闭包参数，run没有
 */
fun runTest(){
    var result = findPerson()?.run {
        work()
        println(age)
        "run test"
    }
    println(result)
}
/**
 * also apply 都不返回闭包执行结果,返回的是this（调用者），区别在于also有闭包参数，apply没有
 */
fun alsoTest(){
    var result = "alsoTest".also {
        println(it.length)
        100
    }
    println("alsoTest result = " + result)
}

/**
 * 从[初始]值开始累加值，并从左到右对当前累加器值和每个元素应用[操作]。
 * 与reduce类似,reduce没有初始值是第一个元素
 * fold必须手动传一个初始值
*/
fun foldTest(){
    var arr = intArrayOf(1,2,3,4,5,6,)
    //var sum:(Int,Int)->Int= {x:Int,y:Int -> x + y}
    var sum = {x:Int,y:Int -> x + y}
    var fold = arr.fold(2,sum)
    println("foldTest fold = " + fold)
}
/**
 * 根据条件过滤元素
 */
fun filterTest(){
    println("filterTest")
    val array = intArrayOf(1,2,3,4,5,6)
    array.filter {
        it%2 == 0
    }.forEach{
        println(it)
    }
}
/**
 * takeWhile和filter一样都是过滤用的函数
 * 和filter不同地方在filter总是会遍历当前IntArray的所有元素
 * 而takeWhile在第一次发现predict不满足的时候就不再遍历
 * 后面的元素即使满足条件也不会加入到结果中
 */
fun takeWhile(){
    println("takeWhile")
    var array: IntArray = intArrayOf(1,2,3,4,5,6)
    val takeWhile = array.takeWhile {
        it <= 3
    }
    takeWhile.forEach({x:Int -> println(x)})
}
/**
 * use是针对那些实现了Closable接口的对象的扩展方法，也就是大部分的IO操作相关类会有这个扩展高阶方法，
 * use内已经捕获了异常，并调用了close方法。
 */
fun use(){
    println("use")
    val file = File("D:\\test.txt")
    println(file.exists().toString()+"---"+file.isFile.toString())
    val bufferedReader = BufferedReader(FileReader(file))
    val result = bufferedReader.use {
        var str = it.readLine()
        println("str = $str")
        str
    }
    println("result = " + result)
}
fun main() {
    //forEachTest()
    //mapTest()
    //flatMapTest()
    //reduceTest()
    //(0..6).forEach { println(findPerson())}
    //applyTest()
    //withTest()
    //letTest()
    //runTest()
    //alsoTest()
    //foldTest()
    //filterTest()
    //takeWhile()
    println("-----------")
}

