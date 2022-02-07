package ASM;

import ASM.Operand.ASMAddress;
import ASM.Operand.IntImm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class StackFrame{
    public int SpaceSize;
    public ASMFunction belFunc;
    public ArrayList<ASMAddress> LocalRegAddr = new ArrayList<>();//belong to this Space
    public ArrayList<ASMAddress> ParameterAddr = new ArrayList<>();//not belong to this Space
//    public ArrayList<ASMAddress>
    public HashMap<ASMFunction,ArrayList<ASMAddress> > CalleeAddr = new HashMap<>();//belong to This Space
    public StackFrame(ASMFunction belFunc) {
        this.belFunc = belFunc;
    }
    public void InitInit() {
        SpaceSize = 0;
        for(ArrayList<ASMAddress> CalleeList : CalleeAddr.values()){
            int tmp = 0;
            for(int i=0;i<CalleeList.size();++i) {
                CalleeList.get(i).offset = new IntImm(tmp);
                tmp+=4;
            }
            SpaceSize = Integer.max(tmp,SpaceSize);
        }
    }
    public void Init() {
        int offset = SpaceSize;
        for(int i=0;i<ParameterAddr.size();++i) {
            ParameterAddr.get(i).offset = new IntImm(offset);
            offset+=4;
        }
    }
}
