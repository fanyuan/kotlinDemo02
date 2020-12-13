package com.kotlin.demo02.manager

interface Driver{
    fun drive()
}
interface Writer{
    fun write()
}
class CarDriver : Driver {
    override fun drive() {
        //TODO("Not yet implemented")
        println("在开车")
    }
}
class PPTWriter : Writer{
    override fun write() {
        //TODO("Not yet implemented")
        println("ppt制作中")
    }

}
class Manager : Driver,Writer {
    override fun drive() {
        //TODO("Not yet implemented")
        println("Manager === driving")
    }

    override fun write() {
        //TODO("Not yet implemented")
        println("Manager === writing")
    }
}
class MidManager(val d:Driver,val w:Writer) : Driver,Writer {
    override fun drive() {
        //TODO("Not yet implemented")
        d.drive()
    }

    override fun write() {
        //TODO("Not yet implemented")
        w.write()
    }
}
class SeniorManager(val driver:Driver, val writer:Writer):Driver by driver,Writer by writer
fun main() {
    val driver:Driver = CarDriver()
    driver.drive()
    println("-----------------")
    var m : Manager = Manager()
    m.drive()
    m.write()
    println("-----------------")
    val mManager:MidManager = MidManager(CarDriver(),PPTWriter());
    mManager.drive()
    mManager.write()
    println("-----------------")
    val seniorManager:SeniorManager = SeniorManager(CarDriver(),PPTWriter())
    seniorManager.drive()
    seniorManager.write()
}