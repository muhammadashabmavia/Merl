package gcd.Lab3

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import chisel3.util.Valid

class Task3test_lab3 extends FreeSpec with ChiselScalatestTester {
  "Lab3 Task3" in {
    test(new decoder_with_valid()) { a =>
      a.io.in.poke(4.U)
      a.clock.step(1)
      val expectedOutput = Valid(2.U)
      a.io.out.expect(expectedOutput)
    }
  }
}
