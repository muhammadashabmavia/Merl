// package lab1Q1

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class testcounter_counter extends FreeSpec with ChiselScalatestTester {

//   "Chisel Tester File" in {
//     test(new counter(4.U)) { a =>
//       a.clock.step(5) // Step for 5 clock cycles
//       a.io.result.expect(0.U) // Expect the result to be 0 after the counter resets
//     }
//   }
// }
