package gcd.lab3

import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
  val fnct3 = Input(UInt(3.W))
  val branch = Input(Bool())
  val a = Input(UInt(32.W))
  val b = Input(UInt(32.W))
  val results = Output(Bool())
}

class BranchControl extends Module {
  val io = IO(new LM_IO_Interface_BranchControl)

  val results = Wire(Bool())

  switch(io.fnct3) {
    is(0.U) {
      results := io.branch
    }
    is(1.U) {
      results := (io.a === io.b) //BEQ Branch if Equal
    }
    is(2.U) {
      results := (io.a =/= io.b) //BNE Branch if Not Equal.
    }
    is(3.U) {
      results := (io.a.asSInt < io.b.asSInt) //BLT Branch if Less Than
    }
    is(4.U) {
      results := (io.a.asSInt >= io.b.asSInt) //BGE Branch if Greater Than or Equal
    }
    is(5.U) {
      results := (io.a < io.b) //BLTU Branch if Less Than, Unsigned.
    }
    is(6.U) {
      results := (io.a >= io.b) //BGEU Branch if Greater Than or Equal, Unsigned
    }
  }
  io.results := results
}