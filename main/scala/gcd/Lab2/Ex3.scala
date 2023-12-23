package lab2

import chisel3._
import chisel3.util._
class Exercise3 extends Module {
  val io = IO(new Bundle {
    val int0 = Input(UInt(1.W))
    val int1 = Input(UInt(1.W))
    val int2 = Input(UInt(1.W))
    val int3 = Input(UInt(1.W))
    val out = Output(UInt(2.W))
  })
  val int4 = Cat(io.int3, io.int2,io.int1, io.int0)
  io.out := Mux1H(int4, Seq(0.U, 1.U, 2.U, 3.U)) 
}