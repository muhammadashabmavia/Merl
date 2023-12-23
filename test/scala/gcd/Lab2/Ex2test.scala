    package gcd

    import chisel3._
    import chisel3.tester._
    import org.scalatest.FreeSpec
    import chisel3.experimental.BundleLiterals._
    class Ex2test extends  FreeSpec with  ChiselScalatestTester{
    
    "Lab2 Exercise2"in{
        test(new Ex2())
        { a=>
        // a.io.in0.poke(0.B)
        // a.io.in1.poke(1.B)
        // a.io.in2.poke(1.B)
        // a.io.in3.poke(1.B)
        // a.io.in4.poke(1.B)
        // a.io.in5.poke(1.B)
        // a.io.in6.poke(1.B)
        // a.io.in7.poke(1.B)
        //a.io.sel.poke(1.U)
        // 
        a.clock.step(1)
        
        a.io.out.expect(1.B)
    }
}
} 

