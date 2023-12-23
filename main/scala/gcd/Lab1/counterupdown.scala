package gcd
import chisel3 . _
import chisel3 . util . _
import java . io . File
class counterupdown ( n : Int ) extends Module {
val io = IO ( new Bundle {
val data_in = Input ( UInt ( n . W ) )
val reload = Input ( Bool () )
val out = Output ( Bool () )
})
val counter = RegInit (0. U ( n . W ) )
val max_count = RegInit (0.B)
  io.out := 0.B

  when(counter < io.data_in 	&& !max_count)
  {
    io.out := (counter === 0.U)
    counter := counter + 1.U
    max_count := ((counter + 1.U) === io.data_in)
  }.elsewhen(max_count && io.reload)
  {
    io.out := (counter === io.data_in)
    counter := counter - 1.U
    	max_count:= !((counter - 1.U) === 0.U) 
  }
}