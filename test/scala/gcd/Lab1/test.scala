package practise
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class test_adder extends FreeSpec with ChiselScalatestTester{
"Chisel Tester File adder" in {
    test(new adder){  a=>
    a.io.in1.poke(1.S)
    a.io.in2.poke(1.S)   
    a.clock.step(2)
    a.io.out.expect(2.S)
    
    }



}


}