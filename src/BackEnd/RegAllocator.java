package BackEnd;

import ASM.*;
import ASM.Inst.ASMBinaryInst;
import ASM.Inst.ASMLoadInst;
import ASM.Inst.ASMStoreInst;
import ASM.Operand.ASMAddress;
import ASM.Operand.IntImm;
import ASM.Operand.PhysicalReg;
import ASM.Operand.VirtualReg;

import java.util.ArrayList;
import java.util.HashMap;

public class RegAllocator {
    public void RegAllocate(ASMModule thisMod) {

        for(ASMFunction thisFunc:thisMod.Funcs.values()) {
            HashMap<VirtualReg, ASMAddress> Addr_Map = new HashMap<>();
            StackFrame curStk = thisFunc.stk;
            curStk.SpaceSize = 0;
//            ASMBasicBlock curBlock = thisFunc.entry;
            for(ASMBasicBlock curBlock = thisFunc.entry;curBlock!=null;curBlock = curBlock.nxt_Block) {
                ASMInst curInst = curBlock.Inst_begin;
                while(curInst!=null) {
                    int cnt_phy = 0;
//                    ASMInst finalCurInst = curInst;
                    for(VirtualReg x:curInst._rd)
                    {
                        if(x.Allocated_Reg==null) {
                            if(!Addr_Map.containsKey(x)) {
                                Addr_Map.put(x,new ASMAddress(PhysicalReg.getv("sp"),new IntImm(curStk.SpaceSize)));curStk.SpaceSize+=4;
                            }
                            ASMAddress curAddr = Addr_Map.get(x);
                            VirtualReg phy_reg = PhysicalReg.getv("s"+cnt_phy);
//                            System.out.println(phy_reg.toString());
                            curInst.replaceRd(x,phy_reg);
                            curBlock.addAfter(curInst,new ASMStoreInst(phy_reg,curAddr, ASMStoreInst.Op.sw,curBlock));
                            cnt_phy ++;
                        }
                    }
                    for(VirtualReg x:curInst._rs)
                    {
                        if(x.Allocated_Reg==null) {
                            if(!Addr_Map.containsKey(x)) {
                                Addr_Map.put(x,new ASMAddress(PhysicalReg.getv("sp"),new IntImm(curStk.SpaceSize)));curStk.SpaceSize+=4;
                            }
                            ASMAddress curAddr = Addr_Map.get(x);
                            VirtualReg phy_reg = PhysicalReg.getv("s"+cnt_phy);
                            curInst.replaceRs(x,phy_reg);
                            curBlock.addBefore(curInst,new ASMLoadInst(phy_reg,curAddr, ASMLoadInst.Op.lw,curBlock));
                            cnt_phy ++;
                        }
                    }
                    curInst = curInst.Nxt;
                }
            }
            curStk.LocalRegAddr = new ArrayList<>(Addr_Map.values());
            curStk.Init();
            if(curStk.SpaceSize!=0) {
                thisFunc.entry.addFront(new ASMBinaryInst(PhysicalReg.getv("sp"), PhysicalReg.getv("sp"), null, new IntImm(-curStk.SpaceSize), ASMBinaryInst.Op.addi, thisFunc.entry));
                thisFunc.exit.addBefore(thisFunc.exit.Inst_end, new ASMBinaryInst(PhysicalReg.getv("sp"), PhysicalReg.getv("sp"), null, new IntImm(curStk.SpaceSize), ASMBinaryInst.Op.addi, thisFunc.entry));
            }
        }
    }
}
