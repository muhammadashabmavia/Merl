 package gcd.Lab1

    import chisel3._
    import chisel3.tester._
    import org.scalatest.FreeSpec
    import chisel3.experimental.BundleLiterals._
    class msbcountertest extends  FreeSpec with  ChiselScalatestTester{
    
    "Chisel MSB File"in{
        test(new Counter(2.U))
        { a=>
        a.clock.step(20)
        a.io.result.expect(0.B)
    }
}
} 
