    package gcd.lab3

    import chisel3._
    import chisel3.util._

    class RISCV_ALU extends Bundle {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val aluCtrl = Input(UInt(4.W))
    val result = Output(UInt(32.W))
    }

    class ALUOne extends Module {
    val io = IO(new RISCV_ALU)

    val result = WireInit(0.U(32.W))
    

            switch(io.aluCtrl) {
                is("b0000".U) { 
                    result := io.a + io.b
                } // ADD operation
                
                is("b0001".U) { 
                    result := io.a - io.b 
                } // SUB operation

                is("b0010".U) { 
                    result := io.a & io.b 
                } // AND operation

                is("b0011".U) { 
                    result := io.a | io.b 
                } // OR operation

                is("b0100".U) { 
                    result := io.a ^ io.b 
                } // XOR operation

                is("b0101".U) { 
                    result := Mux(io.a.asSInt < io.b.asSInt, 1.U, 0.U) 
                } // SLT operation Set on Less Than

                is("b0110".U) { 
                    result := Mux(io.a < io.b, 1.U, 0.U) 
                } // SLTU operation Set on Less Than Unsigned.

                is("b0111".U) { 
                    result := io.a << io.b(4, 0) 
                } // SLL operation

                is("b1000".U) { 
                    result := io.a >> io.b(4, 0) 
                } // SRL operation

                is("b1001".U) { 
                    result := (io.a.asSInt >> io.b(4, 0)).asUInt 
                } // SRA operation
                
            }
            io.result := result
            }