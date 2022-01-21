package ASM.Operand;

import Util.error.SemanticError;
import Util.position;

public class IntImm extends ASMOperand{
    int Val;
    public IntImm(int Val) {
//        if(Val>=2048||Val<=-2048){
//            throw new SemanticError("Fuck Imm",new position(1,1));
//        }
        this.Val = Val;
    }
    @Override
    public String toString(){
        return Integer.toString(Val);
    }
}
