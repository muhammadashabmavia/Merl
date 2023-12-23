package gcd
import chisel3._

class Mux_2to1_IO extends Bundle {
  val in_A = Input(UInt(32.W))
  val in_B = Input(UInt(32.W))
  val select = Input(Bool())
  val out = Output(UInt(32.W))
}

class Ex1 extends Module {
  val io = IO(new Mux_2to1_IO)

  // Perform the selection without using Mux
  when(io.select === 0.B) {
    io.out := io.in_A
  }.otherwise {
    io.out := io.in_B
  }
}
