package gcd.Lab4
import chisel3._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is
object  function{
val beq = 0.U(4.W)
val bne = 1.U(4.W)
val blt = 2.U(4.W)
val bge = 3.U(4.W)
val bltu= 4.U(4.W)
val bgeu = 5.U(4.W)
}
import function._
class branch extends Module {
  val io = IO(new Bundle {
  val A = Input(UInt(32.W))
  val B= Input(UInt(32.W))
  val func3= Input(UInt(4.W))
  val out = Output(Bool())
  })
      io.out :=0.U
      
  util.switch(io.func3) {
    is(beq) {
      io.out := (io.A === io.B)
    }
    is(bne) {
      io.out := (io.A =/= io.B)
    }
    is(blt) {
      io.out := (io.A < io.B)
    }
    is(bge) {
      io.out :=  (io.A >= io.B)
    }
     is(bltu) {
  
      io.out :=  (io.A < io.B)
    }
     is(bgeu) {
      io.out :=  (io.A >= io.B)
    }
    
  }
}