
package lab1
import chisel3._
class countersigned( counterBits:Int )extends  Module{
  
    val io = IO( new Bundle {

val result = Output( SInt())
    })
    val max = (1.S << counterBits -1) -1.S
    val count = RegInit(0.S (16.W))
    when (count === max){
count :=0.S
    }
    .otherwise{
count := count + 1.S
    }
    io. result := max
}

