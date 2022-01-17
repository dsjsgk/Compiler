package MIR;

public interface IRvisitor {
    public void visit(BasicBlock tmp);
    public void visit(IRModule tmp);
    public void visit(IRFunction tmp);
    public void visit(AllocaInst tmp);
    public void visit(BitCastInst tmp);
    public void visit(BranchInst tmp);
    public void visit(CallFuncInst tmp);
    public void visit(CmpInst tmp);
    public void visit(GetElementPtrInst tmp);
    public void visit(LoadInst tmp);
    public void visit(MoveInst tmp);
    public void visit(PhiInst tmp);
    public void visit(RetInst tmp);
    public void visit(StoreInst tmp);
    public void visit(BinaryInst tmp);
}
