    package gcd

    import chisel3._
    import chisel3.tester._
    import org.scalatest.FreeSpec
    import chisel3.experimental.BundleLiterals._
    class counter_up_downtest extends  FreeSpec with  ChiselScalatestTester{
    
    "Up Down Counter"in{
        test(new counterupdown(4))
        { a=>
        // a.clock.step(20)
        // a.io.data_in.poke(0.U)
        // a.io.reload.poke(0.B)
        // a.io.out.expect(1.B)
        a.io.data_in.poke(6.U)
      a.io.reload.poke(1.B)
      a.clock.step(20)
      a.io.out.expect(0.B)
    }
}
} 

