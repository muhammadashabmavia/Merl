id: file://<WORKSPACE>/test/scala/gcd/Lab4/Task2test.scala:[86..93) in Input.VirtualFile("file://<WORKSPACE>/test/scala/gcd/Lab4/Task2test.scala", "package gcd.Lab4

import chisel3._
import chiseltest._
import org.scalatest._

class  extends FreeSpec with ChiselScalatestTester{
  "generate immediate values different instruction types" in {
    test(new immgen()) { a =>
      // Alag-alag instruction types ke liye decimal (4-bit) immediate values

      // Type 0: Data load/store logical (I-type)
      a.io.instruction.poke(2.U) // Decimal mein "b0010" ka matlab
      a.io.out.expect(8.U) // Decimal mein "b1000" ka matlab

      // Type 1: I-type jaisa, lekin value do hisson mein stored hoti hai (S-type)
      a.io.instruction.poke(7.U) // Decimal mein "b0111" ka matlab
      a.io.out.expect(56.U) // Decimal mein "b111000" ka matlab

      // Type 2: Aur ek Data load/store logical (I-type) ka udaharan
      a.io.instruction.poke(1.U) // Decimal mein "b0001" ka matlab
      a.io.out.expect(4.U) // Decimal mein "b0100" ka matlab

      // Type 3: Kuch bits jodkar banti hai 12-bit immediate value (SB-type)
      a.io.instruction.poke(3.U) // Decimal mein "b0011" ka matlab
      a.io.out.expect(12.U) // Decimal mein "b1100" ka matlab

      // Type 4: Load upper immediate (U-type)
      a.io.instruction.poke(5.U) // Decimal mein "b0101" ka matlab
      a.io.out.expect(20.U) // Decimal mein "b10100" ka matlab

      // Type 5: Jump-type instruction (J-type)
      a.io.instruction.poke(4.U) // Decimal mein "b0100" ka matlab
      a.io.out.expect(16.U) // Decimal mein "b10000" ka matlab
    }
  }
}
")
file://<WORKSPACE>/test/scala/gcd/Lab4/Task2test.scala
file://<WORKSPACE>/test/scala/gcd/Lab4/Task2test.scala:7: error: expected identifier; obtained extends
class  extends FreeSpec with ChiselScalatestTester{
       ^
#### Short summary: 

expected identifier; obtained extends