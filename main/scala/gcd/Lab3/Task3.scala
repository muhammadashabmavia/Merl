package gcd.Lab3

import chisel3._
import chisel3.util._

class LM_IO_Interface_decoder_with_valid extends Bundle {
  val in = Input(UInt(2.W))
  val out = Valid(Output(UInt(4.W)))
}

class decoder_with_valid extends Module {
  val io = IO(new LM_IO_Interface_decoder_with_valid)

  val outWire = Wire(UInt(4.W))

  switch(io.in) {
    is("b00".U) {
      outWire := "b0001".U
    }
    is("b01".U) {
      outWire := "b0010".U
    }
    is("b10".U) {
      outWire := "b0100".U
    }
    is("b11".U) {
      outWire := "b1000".U
    }
  }

  io.out.valid := true.B
}

