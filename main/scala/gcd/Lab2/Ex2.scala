package gcd

import chisel3._
import chisel3.util._

class Mux_8to1_IO extends Bundle {
    val in0 = Input(Bool())
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val in3 = Input(Bool())
    val in4 = Input(Bool())
    val in5 = Input(Bool())
    val in6 = Input(Bool())
    val in7 = Input(Bool())
    val sel = Input(UInt(3.W))  
    val out = Output(Bool()) 
}
class Ex2 extends Module {
  val io = IO(new Mux_8to1_IO)

  val muxLookupFirst = MuxLookup(io.sel(2), false.B, Array(
    // B1
    (0.U) -> MuxLookup(io.sel(1), io.in0, Array(
      (0.U) -> io.in0,
      (1.U) -> io.in1,
      (2.U) -> io.in2,
      (3.U) -> io.in3
    )),
    // B2
    (1.U) -> MuxLookup(io.sel(1), io.in4, Array(
      (0.U) -> io.in4,
      (1.U) -> io.in5,
      (2.U) -> io.in6,
      (3.U) -> io.in7
    ))
  ))
io.out := MuxLookup(io.sel(0), muxLookupFirst, Array(
    (0.U) -> muxLookupFirst,
    (1.U) -> !muxLookupFirst
  ))
}
