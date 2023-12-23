package gcd.Lab4

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
import ALUOP._


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

class Task4test_ex1 extends FreeSpec with ChiselScalatestTester {
  "Lab4 ex1" in {
    test(new ALUtest()) { c =>
      // ALU operations
      val array_op = Array(ALU_ADD, ALU_SUB, ALU_AND, ALU_OR, ALU_XOR, ALU_SLT, ALU_SLL, ALU_SLTU, ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B)
      
      val src_a = Random.nextLong() & 0xFFFFFFFFL
        val src_b = Random.nextLong() & 0xFFFFFFFFL
        val opr = 1
        val aluop = array_op(opr)
        // ALU functional implementation using Scala match
        val result = aluop match {
          case ALU_ADD => src_a + src_b
          case ALU_SUB => src_a - src_b
          case ALU_AND => src_a & src_b
          case ALU_OR => src_a | src_b
          case ALU_XOR => src_a ^ src_b
          case ALU_SLT => (src_a.toInt < src_b.toInt).asInstanceOf[Int]
          case ALU_SLL => src_a << (src_b & 0x1F)
          case ALU_SLTU => (src_a < src_b).asInstanceOf[Int]
          case ALU_SRL => src_a << (src_b & 0x1F)
          case ALU_SRA => src_a >> (src_b & 0x1F)
          case ALU_COPY_A => src_a * src_b
          case ALU_COPY_B => src_b / src_b
        }

        val result1: BigInt = if (result < 0) (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL else result & 0xFFFFFFFFL
        c.io.a.poke(src_a.U)
        c.io.b.poke(src_b.U)
        c.io.aluCtrl.poke(aluop)
        c.clock.step(1)
        c.io.result.expect(result1.asUInt)
    }
  }
}