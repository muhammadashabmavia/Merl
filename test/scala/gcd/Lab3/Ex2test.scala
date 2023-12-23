package gcd.lab3

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class Ex2test_lab3 extends FreeSpec with ChiselScalatestTester {
  "Lab3 Exercise2" in {
    test(new ALUOne()) { a =>
      a.io.a.poke(32.U)
      a.io.b.poke(2.U)
      a.io.aluCtrl.poke("b0001".U)
      // a.clock.step(1)
      a.io.result.expect(30.U)
    }
  }
}


