package gcd.Lab5

import chisel3._
import chiseltest._
import org.scalatest._

class Ex1test extends FreeSpec with ChiselScalatestTester {
  "Ex1test Lab5" in {
    test(new ALU(32)) { dut =>
      dut.io.arg_x.poke(3.U)
      dut.io.arg_y.poke(1.U)
      dut.io.alu_oper.poke(1.U) // Fix the typo here
      dut.clock.step(1) // Cycle 1: Inputs setup and operation detection
      dut.io.alu_out.expect(3.U) // Cycle 2: Check output
    }
  }
}
