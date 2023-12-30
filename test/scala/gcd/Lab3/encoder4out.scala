package lab3
import chisel3._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is
class encoderswitch extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(2.W))
  })
  io.out := 0.U // Default value
  util.switch(io.in) {
    is("b0001".U) {
      io.out := "b00".U
    }
    is("b0010".U) {
      io.out := "b01".U
    }
    is("b0100".U) {
      io.out := "b10".U
    }
    is("b1000".U) {
      io.out := "b11".U
    }
  }
}