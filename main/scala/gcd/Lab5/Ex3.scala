package gcd.Lab5

import chisel3._

class Operator[T<: Data](n:Int, gen: T)(op: (T,T)=>T) extends Module{
    require(n>0)
    val io=IO(new Bundle{
        val in=Input(Vec(n,gen))
        val out=Output(Vec(n-1,gen))
    })
    for (i <- 0 until n-1) {
        io.out(i):= op(io.in(i),io.in(i+1))
        
    }
}

//Ab jo modification chahiye uska matlab yeh hai ke, har input element ke liye ek output elements ka vector banaya jaaye aur har input element pe alag-alag operation apply kiya jaaye, aur jo result aata hai woh sahi output element mein assign ho.
