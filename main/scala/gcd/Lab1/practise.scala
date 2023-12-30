package practise
import chisel3._
import chisel3.util._

class adder extends Module{
val io = IO(new Bundle{
    val in1 = Input(SInt(3.W))
    val in2 = Input(SInt(3.W))
    val out = Output(SInt(3.W))

    } )
io.out := io.in1 + io.in2
}