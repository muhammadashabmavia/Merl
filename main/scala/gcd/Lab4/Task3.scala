package gcd.Lab4
import chisel3._
import chisel3.util._
import chisel3.util.MuxLookup
import scala.annotation.switch
import chisel3.util.is

object ALUOP {
  val ALU_ADD  = 0.U(4.W)
  val ALU_SUB  = 1.U(4.W)
  val ALU_AND  = 2.U(4.W)
  val ALU_OR   = 3.U(4.W)
  val ALU_XOR  = 4.U(4.W)
  val ALU_SLT  = 5.U(4.W)
  val ALU_SLL  = 6.U(4.W)
  val ALU_SLTU = 7.U(4.W)
  val ALU_SRL  = 8.U(4.W)
  val ALU_SRA  = 9.U(4.W)
  val ALU_COPY_A = 10.U(4.W)
  val ALU_COPY_B = 11.U(4.W)
}

class ALUIO extends Bundle {
  val in_A = Input(UInt(32.W))
  val in_B = Input(UInt(32.W))
  val alu_Op = Input(UInt(4.W))
  val out = Output(UInt(32.W))
  val sum = Output(UInt(32.W))
}

class ALU extends Module {
  val io = IO(new ALUIO)

  val sum = io.in_A + Mux(io.alu_Op(0), -io.in_B, io.in_B)
  val cmp = Mux(io.in_A(31) === io.in_B(31), sum(31),
              Mux(io.alu_Op(1), io.in_B(31), io.in_A(31)))
  val shamt = io.in_B(4, 0).asUInt
  val shin = Mux(io.alu_Op(3), io.in_A, Reverse(io.in_A))
  val shiftr = (Cat(io.alu_Op(0) && shin(31), shin).asSInt >> shamt)(31, 0)
  val shiftl = Reverse(shiftr)

  val out = MuxCase(0.U, Array(
    (io.alu_Op === ALUOP.ALU_ADD)  -> sum,
    (io.alu_Op === ALUOP.ALU_SUB)  -> sum,
    (io.alu_Op === ALUOP.ALU_SLT || io.alu_Op === ALUOP.ALU_SLTU) -> cmp,
    (io.alu_Op === ALUOP.ALU_SRA || io.alu_Op === ALUOP.ALU_SRL)  -> shiftr,
    (io.alu_Op === ALUOP.ALU_SLL) -> shiftl,
    (io.alu_Op === ALUOP.ALU_AND) -> (io.in_A & io.in_B),
    (io.alu_Op === ALUOP.ALU_OR)  -> (io.in_A | io.in_B),
    (io.alu_Op === ALUOP.ALU_XOR) -> (io.in_A ^ io.in_B),
    (io.alu_Op === ALUOP.ALU_COPY_A) -> io.in_A,
    (io.alu_Op === ALUOP.ALU_COPY_B) -> io.in_B
  ))

  io.out := out
  io.sum := sum
}

