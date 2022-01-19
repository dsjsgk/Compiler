package MIR;
import java.util.ArrayList;
public class IRFunction extends Basis{
    public IRModule mod;
    public FuncType functp;
    public BasicBlock entry;
    public BasicBlock exit;
    public BasicBlock ret;
    public ArrayList<Parameter> paras_list;
    public String id;
    public register retval;
    public register retval_addr;
    public boolean isreturned;
    public boolean isBuiltin;
    public register thisptr;
    public IRFunction(String id,IRModule mod,ArrayList<Parameter> paras_list,BaseType rettp,boolean isBuiltin) {
        this.id = id;
        this.mod = mod;
        this.paras_list = paras_list;
        this.isBuiltin = isBuiltin;
        ArrayList<BaseType> temp = new ArrayList<BaseType>();
        paras_list.forEach(x->temp.add(x.tp));
        this.functp = new FuncType(rettp,temp);
        if(!isBuiltin) {
//            System.out.println(id);
            entry = new BasicBlock(this,"entry");
            exit = entry;
            ret = new BasicBlock(this,"return");
//            System.out.println(id);
            if(this.functp.ret_tp instanceof VoidType||this.functp.ret_tp instanceof NullType) {
                ret.addBack(new RetInst(new VoidType(), null,ret));

            }
            else {
                retval_addr = new LocalReg("returnValue$addr",new PointerType(this.functp.ret_tp));
                entry.addBack(new AllocaInst(this.functp.ret_tp,retval_addr,entry));
                entry.addBack(new StoreInst(retval_addr,this.functp.ret_tp.defaultval(),entry));
//                System.out.println(this.functp.ret_tp.defaultval().toString());
                retval = new LocalReg("returnValue",this.functp.ret_tp);
                ret.addBack(new LoadInst(this.functp.ret_tp,retval,retval_addr,ret));
                ret.addBack(new RetInst(this.functp.ret_tp,retval,ret));
            }
        }
    }
    public void addBlock(BasicBlock tmp) {
        tmp.pre_block = exit;
        tmp.nxt_block = null;
        if(entry==null) entry = tmp;
        else exit.nxt_block = tmp;
        exit = tmp;
//        tmp.nxt_block = null;
    }
    public void finish() {
        exit.addBack(new BranchInst(ret,null,null,exit));
        addBlock(ret);
    }
    public void accept(IRvisitor tmp){
        tmp.visit(this);
    }
    public String declareToString() {
        StringBuilder header = new StringBuilder("declare ");
        header.append(functp.ret_tp.toString());
        header.append(" @").append(id);

        header.append("(");
//        System.out.println(id);
//        System.out.println(paras_list.size());
        for (int i = 0; i < paras_list.size(); i++) {
            Parameter parameter = paras_list.get(i);
            header.append(parameter.tp.toString()).append(" ");
            header.append(parameter.toString());
            if (i != paras_list.size() - 1)
                header.append(", ");
        }
        header.append(")");

        return header.toString();
    }
    public String toString() {
        return "@"+id;
    }
}
