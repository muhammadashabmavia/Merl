    package gcd.lab3

    import chisel3._
    import chisel3.tester._
    import org.scalatest.FreeSpec
    import chisel3.experimental.BundleLiterals._
    class Ex1test_lab3 extends  FreeSpec with  ChiselScalatestTester{
    
    "Lab3 Exercise1"in{
        test(new Encoder4to2())
        { a=>
        a.io.in.poke(4.U)
        a.io.out.expect(2.U)
    }
}
} 

