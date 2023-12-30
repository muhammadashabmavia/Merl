package lab3
import chisel3._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is
class immgen extends Module {
  val io = IO(new Bundle {
    val instruction = Input(UInt(32.W))
    
  val out = Output(UInt(12.W))
  })
io.out := 0.U
    val out = io.instruction(11 , 0)
      
}