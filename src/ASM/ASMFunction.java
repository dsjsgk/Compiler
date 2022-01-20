package ASM;

import MIR.BasicBlock;
import MIR.IRFunction;

import java.util.HashMap;

public class ASMFunction extends ASMBase{
    public String Identifier;
    public ASMModule thisMod;
    public ASMBasicBlock exit,entry;
    public StackFrame stk;
    public HashMap<BasicBlock,ASMBasicBlock> BlockMap = new HashMap<>();
    public ASMFunction(ASMModule thisMod, IRFunction thisFunc) {
        this.thisMod = thisMod;
        this.Identifier = thisFunc.id;
        if(thisFunc.isBuiltin) return ;
        int tot = 0;
        BasicBlock ptr = thisFunc.entry;
        while(ptr!=null) {
            ASMBasicBlock nw = new ASMBasicBlock(".L"+thisMod.Funcs.size()+"_"+tot,this);
            this.addBlock(nw);
            BlockMap.put(ptr,nw);
            ptr = ptr.nxt_block;
            tot++;
        }
    }
    public void addBlock(ASMBasicBlock block) {
        if(entry == null) {
            entry = block;
            exit = block;
        }
        else{
            exit.nxt_Block = block;
            block.pre_Block = exit;
            exit = block;
        }
    }
    @Override
    public String toString(){
        return Identifier;
    }
}
