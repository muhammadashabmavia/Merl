package gcd.Lab4

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
import ALUOP._

class TestALU(c: ALU)
    extends FreeSpec
    with ChiselScalatestTester
    with Matchers {
  "ALU Test" in {
    test(new ALU).withAnnotations(Seq(VerilatorBackendAnnotation)) { a =>
      val array_op = Array(
        ALU_ADD,
        ALU_SUB,
        ALU_AND,
        ALU_OR,
        ALU_XOR,
        ALU_SLT,
        ALU_SLL,
        ALU_SLTU,
        ALU_SRL,
        ALU_SRA,
        ALU_COPY_A,
        ALU_COPY_B
      )

      for (i <- 0 until 100) {
        val src_a = Random.nextLong() & 0xffffffffL
        val src_b = Random.nextLong() & 0xffffffffL
        val opr = Random.nextInt(13) // To include ALU_XXX
        val aluop = array_op(opr)

        val result = aluop match {
          case ALU_ADD    => src_a + src_b
          case ALU_SUB    => src_a - src_b
          case ALU_AND    => src_a & src_b
          case ALU_OR     => src_a | src_b
          case ALU_XOR    => src_a ^ src_b
          case ALU_SLT    => (src_a.toInt < src_b.toInt).asInstanceOf[Int]
          case ALU_SLL    => src_a << (src_b & 0x1f)
          case ALU_SLTU   => (src_a < src_b).asInstanceOf[Int]
          case ALU_SRL    => src_a >> (src_b & 0x1f)
          case ALU_SRA    => src_a.toInt >> (src_b & 0x1f)
          case ALU_COPY_A => src_a
          case ALU_COPY_B => src_b
          case _          => 0
        }

        val result1: BigInt =
          if (result < 0)
            (BigInt(0xffffffffL) + result + 1) & 0xffffffffL
          else result & 0xffffffffL

        a.io.in_A.poke(src_a.U)
        a.io.in_B.poke(src_b.U)
        a.io.alu_Op.poke(aluop)
        a.clock.step(1)
        a.io.out.expect(result1.asUInt)
      }
    }
  }
}
