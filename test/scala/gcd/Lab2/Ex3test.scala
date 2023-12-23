package lab2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Exercise3Tester extends FreeSpec with ChiselScalatestTester {
  "Lab2 Exercise3Tester Chisel Tester" in {
    test(new Exercise3) { a =>
      a.io.int0.poke((0.U).asBool)
      a.io.int1.poke((0.U).asBool)
      a.io.int2.poke((0.U).asBool)
      a.io.int3.poke((1.U).asBool)
      a.io.out.expect(3.U)
      a.clock.step(1)
    }
  }
}