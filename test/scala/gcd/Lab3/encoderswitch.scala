package gcd.lab3

import chisel3._
import chisel3.util._

class encoderSwitch extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(2.W))
    val out = Output(UInt(4.W))
  })

  io.out := 0.U // Default value

  util.switch(io.in) {
    is("b00".U) {
      io.out := "b1000".U
    }
    is("b01".U) {
      io.out := "b0100".U
    }
    is("b10".U) {
      io.out := "b0010".U
    }
    is("b11".U) {
      io.out := "b0001".U
    }
  }
}





