package ASM;

import ASM.Operand.ASMGlobalVar;
import MIR.GlobalReg;
import java.util.HashMap;

public class ASMModule{
    public HashMap<String,ASMFunction> Funcs = new HashMap<>();
    public HashMap<String,ASMFunction> Sys_Funcs = new HashMap<>();
    public HashMap<String, ASMGlobalVar> GlobalVars = new HashMap<>();
    public ASMModule(){

    }

}
