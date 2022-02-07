package BackEnd;

import ASM.ASMBasicBlock;
import ASM.ASMFunction;
import ASM.ASMInst;
import ASM.ASMModule;
import ASM.Inst.ASMMvInst;
import ASM.Operand.ASMGlobalVar;

public class ASMPrinter {
    public String indent = null;
    public void println(String str) {
        System.out.println(indent+str);
    }
    public void print(String str) {
        System.out.print(indent+str);
    }
    public void PrintMod(ASMModule Mod) {
        indent = "\t";
        println(".text");
        indent = "";
        println("");
        for (ASMFunction function : Mod.Funcs.values())
            PrintFunc(function);
        println("");
        indent = "\t";
        println(".section\t.sdata,\"aw\",@progbits");
        for (ASMGlobalVar g : Mod.GlobalVars.values()) {
            if (g.tp!=ASMGlobalVar.Type._string) {
                println(".global\t" + g.Identifier);
                println(".p2align\t2");
            }
            println(g.Identifier + ":");
            println(g.toString());
        }
        indent = "";
    }
    public void PrintFunc(ASMFunction Func) {
        indent = "\t";
        println(".globl\t" + Func.Identifier);
        println(".p2align\t2");
        println(".type\t" + Func.Identifier +",@function");
        indent = "";
        println(Func.toString() + ":");
        ASMBasicBlock ptr = Func.entry;
        while(ptr!=null) {
            PrintBlock(ptr);
            ptr = ptr.nxt_Block;
        }
        indent = "\t";
        println(".size\t" + Func.Identifier + ", " + ".-" + Func.Identifier);
        indent = "";
    }
    public void PrintBlock(ASMBasicBlock curBlock){
        println(curBlock.Identifier + ":");
        indent = "\t";
        for (ASMInst inst = curBlock.Inst_begin;inst!=null;inst = inst.Nxt) {
            if(inst instanceof ASMMvInst&&((ASMMvInst) inst).rd.Allocated_Reg.Identifier.equals(((ASMMvInst) inst).rs.Allocated_Reg.Identifier)) {
                continue;
            }
            println(inst.toString());
        }
        indent = "";
    }
}
