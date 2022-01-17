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
    }
    public void addBlock(BasicBlock tmp) {
        tmp.pre_block = exit;
        if(entry==null) entry = tmp;
        else exit.nxt_block = tmp;
        exit = tmp;
        tmp.nxt_block = null;
    }
}
