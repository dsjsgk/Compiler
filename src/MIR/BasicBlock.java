package MIR;
import java.util.ArrayList;
public class BasicBlock {
    public IRFunction func;
    public BasicBlock pre_block,nxt_block;
    public Inst begin_Inst,end_Inst;
    public String id;
    public ArrayList<BasicBlock> successors,predecessors;
    public static int Num = 0;
    public BasicBlock(IRFunction func,String id) {
        this.func = func; this.id = id + (++Num);
        pre_block = null;
        nxt_block = null;
        begin_Inst = null;
        end_Inst = null;
        successors = new ArrayList<BasicBlock>();
        predecessors = new ArrayList<BasicBlock>();
    }
    public String toString () {return "%"+id;}
    public void addBack(Inst tmp) {
        if(begin_Inst==null&&end_Inst==null) {
            begin_Inst = tmp;
            end_Inst = tmp;
        }
        else {
            end_Inst.Nxt = tmp;
            tmp.Pre = end_Inst;
            end_Inst = tmp;
        }
    }
    public void addFront(Inst tmp) {
        if(begin_Inst==null&&end_Inst==null) {
            begin_Inst = end_Inst = tmp;
        }
        else {
            begin_Inst.Pre = tmp;
            tmp.Nxt = begin_Inst;
            begin_Inst = tmp;
        }
    }
    public void _Init() {
        Inst ptr = begin_Inst;
        while(ptr!=null) {
            if(ptr instanceof BranchInst) {
                if(((BranchInst) ptr).b1!=null) {
                    ((BranchInst) ptr).b1.predecessors.add(this);
                    this.successors.add(((BranchInst) ptr).b1);
                }
                if(((BranchInst) ptr).b2!=null) {
                    ((BranchInst) ptr).b2.predecessors.add(this);
                    this.successors.add(((BranchInst) ptr).b2);
                }
            }
            ptr = ptr.Nxt;
        }
    }
    public void addInstBefore(Inst a,Inst b) {
        if(a==begin_Inst) begin_Inst = b;
        b.Pre = a.Pre;
        b.Nxt = a;
        if(a.Pre!=null) a.Pre.Nxt = b;
        a.Pre = b;
    }
    public void accept(IRvisitor tmp){
        tmp.visit(this);
    }
}
