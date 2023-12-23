    package gcd

    import chisel3._
    import chisel3.tester._
    import org.scalatest.FreeSpec
    import chisel3.experimental.BundleLiterals._
    class Ex1test extends  FreeSpec with  ChiselScalatestTester{
    
    "Lab2 Exercise1"in{
        test(new Ex1())
        { a=>
        a.io.in_A.poke(6.U)
        a.io.in_B.poke(3.U)
        a.io.select.poke(0.B)
        a.clock.step(20)
        a.io.out.expect(6.U)
    }
}
} 

