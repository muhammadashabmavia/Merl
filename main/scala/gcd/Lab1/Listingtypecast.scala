package gcd
import chisel3 . _

class typeCounter ( size : Int , maxValue : UInt ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})
// ' genCounter ' with counter size 'n '
def genCounter ( n : Int , max : UInt ) = {
val count = RegInit (0. U ( n . W ) )
// val maxInt = max.toInt
val maxInt = max.asUInt

when ( count === max ) {
count := 0. U
} .otherwise {  
count := count + 1. U
}
count
}
// genCounter instantiation
val counter1 = genCounter ( size , maxValue )
io . result := counter1 ( size -1)
}