package lab1Q4
import chisel3._
import chisel3.util._

// import chisel3 . _
// import chisel3 . util . _
import java.io.File
class counter_up_down ( n: Int ) extends Module {
val io = IO ( new Bundle {
val data_in = Input ( UInt ( n.W ) )
val reload = Input ( Bool () )
val out = Output ( Bool () )
})
val counter = RegInit (0.U (n.W ) )
val max_count = RegInit (6.U (n.W ) )
// Your code
}
class counter_down_up (max_count: Int) extends Module{
  val io = IO ( new Bundle {
val data_in = Input ( UInt ( max_count. W ) )
val reload = Input ( Bool () )
val out = Output ( Bool () )
})
val counter = RegInit (0. U ( max_count. W ) )
//val max_count = RegInit (6. U ( max_count. W ) )
}
// class counterrev(n: Int) extends Module {
//   val io = IO(new Bundle {
//     val reload = Input(Bool())
//     val out = Output(Bool())
//   })

//   val counter = RegInit(0.U(n.W))
//   val max = n.U(n.W)
//   val shouldReload = Wire(Bool())
//   val shouldCountDown = Wire(Bool())

//   when(counter === max) {
//     shouldReload := true.B
//     shouldCountDown := true.B
//   }.elsewhen(counter === 0.U) {
//     shouldReload := true.B
//     shouldCountDown := false.B
//   }.otherwise {
//     shouldReload := false.B
//     shouldCountDown := false.B
//   }
//   when(io.reload) {
//     counter := Mux(shouldCountDown, counter - 1.U, counter + 1.U)
//   }

//   io.out := shouldReload || counter === 0.U
// }

