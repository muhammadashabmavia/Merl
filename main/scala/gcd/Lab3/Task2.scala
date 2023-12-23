package gcd.Lab3
import chisel3._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is
import chisel3.util.Cat

// class immgen extends Module {
//   val io = IO(new Bundle {
//   val instruction = Input(UInt(32.W))
//   val out = Output(UInt(32.W))
//   })
  
//   val immd_se = Wire(UInt(32.W))

//   immd_se := 0.U 
class immgen extends Module {
  val io = IO(new Bundle {
    val instruction = Input(UInt(32.W))
    val out = Output(UInt(32.W))
  })

  // Immediate generation logic based on instruction type
  val immd_se = Wire(UInt(32.W))
  immd_se := 0.U

    util.switch(io.instruction(6, 0)){
      is(0.U){ // ye data load store logical ma kaam ata hai I type
        immd_se := Cat(io.instruction(31,20), 0.U(12.U))
      }
      is(1.U){ // ye b I type jysa hai bs store krta hai value 2 hisso ma ek source register ma or dosra lower bit ma S type
        immd_se := Cat(io.instruction(31,25), io.instruction(11,7))
      }
      is(2.U){ // ye data load store logical ma kaam ata hai I type
        immd_se := Cat(io.instruction(31,20), 0.U(12.U))
      }
      is(3.U){
        // is ma multple bit connect ho rahi hein apas ma or combine ho k 12 bit bana rahi hien 
        immd_se := Cat(io.instruction(31), io.instruction(7), io.instruction(30, 25), io.instruction(11, 8), 0.U(1.W))
      }
      is(4.U){
        //ye load upper immd hai jo 20 bit ko encode krne k liye use hota hai or 12 bit k saath mil kr 32  bit banata hai
        immd_se := Cat(io.instruction(31,12), 0.U(12.U))
      }
      is(5.U){// J-Type ma 20 bit ki immde value hoti hai or ye  uncondinal jump krta hai jojump offset ki value ko encode krta hai....
      immd_se := Cat(io.instruction(31), io.instruction(19, 12), io.instruction(20), io.instruction(30, 21), 0.U(1.W))
    }
    }
    immd_se := immd_se
}