package gcd.lab3
import chisel3._
import chisel3.util._
import scala.annotation.switch

class EncoderIO extends Bundle {
  val in = Input(UInt(4.W))
  val out = Output(UInt(2.W))
}

class Encoder4to2 extends Module {
  val io = IO(new EncoderIO)

  io.out := 0.U

  switch(io.in) {
    is(1.U) {  
      io.out := 0.U //b0000
    }
    is(2.U) {
      io.out := 1.U //b0001
    }
    is(4.U) {
      io.out := 2.U //b0010
    }
    is(8.U) {
      io.out := 3.U  //b0011
    }
  }
}