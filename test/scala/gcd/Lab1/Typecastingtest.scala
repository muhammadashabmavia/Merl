    package gcd

    import chisel3._
    import chisel3.tester._
    import org.scalatest.FreeSpec
    import chisel3.experimental.BundleLiterals._
    class Listingtypecasttest extends  FreeSpec with  ChiselScalatestTester{
    
    "Chisel Tester File"in{
        test(new typeCounter(4,2.U))
        { a=>
        a.clock.step(1)
        a.io.result.expect(0.B)
    }
}
} 

