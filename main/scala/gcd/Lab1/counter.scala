package gcd

import chisel3._

class counter(counterBits: UInt) extends Module {
  val io = IO(new Bundle {
    val result = Output(UInt())
  })
  
  // Use SInt for count and max
  val count = RegInit(0.S(16.W))
  val max = RegInit(0.S(16.W))

  when(count === max) {
    count := 0.S
  }.otherwise {
    count := count + 1.S
  }

  // Convert count back to UInt for output
  io.result := count.asUInt

  // Convert counterBits to SInt
  val counterBitsSInt = counterBits.asSInt

  when(reset.asBool()) {
    max := 0.S
  }.elsewhen(count === counterBitsSInt) {
    max := 0.S
  }.elsewhen(count < counterBitsSInt) {
    max := count + 1.S
  }
}
