package com.kotlin.demo02

import java.lang.IllegalArgumentException
import com.kotlin.demo02.USBMouse as USBMouse

interface InputDevice{
    fun input(event:Any)
}

interface USBInputDevice : InputDevice

interface BLEInputDevice:InputDevice

interface OpticalMouse
{

}
class MyBLEInputDevice(val name:String):BLEInputDevice{
    override fun input(event: Any) {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "BLEInputDevice name = $name"
    }
}
abstract class USBMouse (val name:String): USBInputDevice,OpticalMouse{
    override fun input(event: Any) {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "name = $name"
    }
}
class LogitechMouse:USBMouse("罗技品牌鼠标"){

}
class OtherInputDevice : InputDevice{
    override fun input(event: Any) {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "OtherInputDevice"
    }
}
class Computer{
    fun addUSBInput(usbInput:USBInputDevice){
        println("加入USB输入设备")
    }
    fun addBLEInput(bleInput:BLEInputDevice){
        println("加入BLEI输入设备")
    }
    fun addInput(input:InputDevice){
        when(input){
            is USBInputDevice -> {
                addUSBInput(input)
            }
            is BLEInputDevice -> {
                addBLEInput(input)
            }
            else -> {
                //println("加入的设备不合规范")
                throw IllegalArgumentException("加入的设备不合规范")
            }
        }
    }
}
fun main() {
    println("===InputDevice===")

    var logitechMouse = LogitechMouse()
    println(logitechMouse.toString())

    var bleInputDevice = MyBLEInputDevice("MyBLEInputDevice")
    println(bleInputDevice.toString())

    var other = OtherInputDevice()
    println(other.toString())

    val computer = Computer()
    try {
        computer.addInput(logitechMouse)
        computer.addInput(bleInputDevice)

    }catch (e:Exception){
        e.printStackTrace()
    }finally {
        println("===InputDevice  finally===")
    }
    computer.addInput(other)

}