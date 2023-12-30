package lab1Q3

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._


class typecasttest_typecast extends  FreeSpec with  ChiselScalatestTester{
  
"Chisel Tester File"in{
    test(new typecast(4,5))
    { a=>
    a.clock.step(1)
    a.io.result.expect(0.B)
}}

} 



//labi ki 1.9