// package gcd.Lab3

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._
// import chisel3.util.Valid
// import gcd.lab3.BranchControl
// class Task1test_lab3 extends FreeSpec with ChiselScalatestTester {
//   "Lab3 Task1" in {
//     test(new BranchControl()) { a =>
//       a.io.fnct3.poke(1.U)
//       a.io.branch.poke(1.B) 
//       a.io.a.poke(1.U)
//       a.io.b.poke(1.U)
//       a.io.results.expect(1.B)
//     }
//   }
// }
