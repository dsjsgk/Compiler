package ASM;

import ASM.Operand.ASMAddress;

import java.util.ArrayList;
import java.util.Stack;

public class StackFrame{
    public int SpaceSize;
    public ASMFunction belFunc;
    public ArrayList<ASMAddress> LocalRegAddr = new ArrayList<>();
    public ArrayList<ASMAddress> ParameterAddr = new ArrayList<>();
    public StackFrame(ASMFunction belFunc) {
        this.belFunc = belFunc;
    }

}
