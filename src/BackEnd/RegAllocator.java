package BackEnd;

import ASM.*;
import ASM.Inst.ASMBinaryInst;
import ASM.Inst.ASMLiInst;
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
            HashMap<VirtualReg, Integer> Imm_Map = new HashMap<VirtualReg, Integer>();
            StackFrame curStk = thisFunc.stk;
            curStk.SpaceSize = 0;
            curStk.InitInit();
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
                                VirtualReg tempReg = PhysicalReg.getv("s7");
                                Addr_Map.put(x,new ASMAddress(tempReg,new IntImm(0)));
                                Imm_Map.put(x,curStk.SpaceSize);curStk.SpaceSize+=4;
                            }
                            ASMAddress curAddr = Addr_Map.get(x);
                            VirtualReg tempReg2 = PhysicalReg.getv("s6");
                            VirtualReg phy_reg = PhysicalReg.getv("s"+cnt_phy);
//                            System.out.println(phy_reg.toString());
                            curInst.replaceRd(x,phy_reg);
                            curBlock.addAfter(curInst,new ASMStoreInst(phy_reg,curAddr, ASMStoreInst.Op.sw,curBlock));
                            curBlock.addAfter(curInst,new ASMBinaryInst(PhysicalReg.getv("s7"),tempReg2,PhysicalReg.getv("sp"),null,ASMBinaryInst.Op.add,curBlock));
                            curBlock.addAfter(curInst,new ASMLiInst(tempReg2,new IntImm(Imm_Map.get(x)),curBlock));
                            cnt_phy ++;
                        }
                    }
                    for(VirtualReg x:curInst._rs)
                    {
                        if(x.Allocated_Reg==null) {
                            if(!Addr_Map.containsKey(x)) {
                                VirtualReg tempReg = PhysicalReg.getv("s7");
                                Addr_Map.put(x,new ASMAddress(PhysicalReg.getv("sp"),new IntImm(curStk.SpaceSize)));
                                Imm_Map.put(x,curStk.SpaceSize);curStk.SpaceSize+=4;
                            }
                            ASMAddress curAddr = Addr_Map.get(x);
                            VirtualReg tempReg2 = PhysicalReg.getv("s6");
                            VirtualReg phy_reg = PhysicalReg.getv("s"+cnt_phy);
                            curInst.replaceRs(x,phy_reg);
                            curBlock.addBefore(curInst,new ASMLiInst(tempReg2,new IntImm(Imm_Map.get(x)),curBlock));
                            curBlock.addBefore(curInst,new ASMBinaryInst(PhysicalReg.getv("s7"),tempReg2,PhysicalReg.getv("sp"),null,ASMBinaryInst.Op.add,curBlock));
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
                VirtualReg tempReg = PhysicalReg.getv("s7");
                thisFunc.entry.addFront(new ASMBinaryInst(PhysicalReg.getv("sp"), PhysicalReg.getv("sp"), tempReg,null, ASMBinaryInst.Op.add, thisFunc.entry));
                thisFunc.entry.addFront(new ASMLiInst(tempReg,new IntImm(-curStk.SpaceSize),thisFunc.entry));
                thisFunc.exit.addBefore(thisFunc.exit.Inst_end,new ASMLiInst(tempReg,new IntImm(curStk.SpaceSize),thisFunc.exit));
                thisFunc.exit.addBefore(thisFunc.exit.Inst_end,new ASMBinaryInst(PhysicalReg.getv("sp"), PhysicalReg.getv("sp"), tempReg,null, ASMBinaryInst.Op.add, thisFunc.exit));

            }
        }
    }
}
