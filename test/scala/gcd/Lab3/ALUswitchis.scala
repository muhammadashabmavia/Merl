package lab3
import chisel3._
import chisel3.util.MuxLookup
// import scala.annotation.switch
import chisel3.util._
// import practice.subtractor
object oprate{
val add = 0.U(4.W)
val sub = 1.U(4.W)
val and = 2.U(4.W)
val or = 3.U(4.W)
val xor= 4.U(4.W)
val slt = 5.U(4.W)
val sll = 6.U(4.W)
val sltu = 7.U(4.W)
val srl = 8.U(4.W)
val sra = 9.U(4.W)
val copyA = 10.U(4.W)
val copyB = 11.U(4.W)
}
import oprate._
class ALUswitchis extends Module {
  val io = IO(new Bundle {
    val A = Input(UInt(32.W))
    val B = Input(UInt(32.W))
    val op = Input(UInt(4.W))
    val out = Output(UInt(32.W))
  })
  val shiftamount = io.B(4, 0)
  io.out := 0.U

  util.switch(io.op) {
    is(add) {
      io.out := io.A + io.B
    }
    is(sub) {
      io.out := io.A -io.B
    }
    is(and) {
      io.out := io.A & io.B
    }
    is(or) {  
      io.out := io.A | io.B
    }
    is(xor) {
      io.out := io.A ^ io.B
    }
    is(slt) {
       when(io.A < io.B) {
        io.out := 1.U
      }
    }
    is(sll) {
      io.out := (io.A << shiftamount)
    }
    is(sltu) {
      // when(io.A < io.B) {
      //   io.out := 1.U
      // }
        when(io.A < io.B) {
        io.out := 1.U
      }
    }
    is(srl) {
      // when(io.A.asUInt < io.B.asUInt) {
      //   io.out := 1.U
      // }
       io.out := io.A >> shiftamount
    }
    is(sra) {
  io.out:=(io.A >> shiftamount)   
        
    }
    is(copyA){

io.out :=io.A

    }
      is(copyB){

io.out :=io.B

    }
    
  }
}