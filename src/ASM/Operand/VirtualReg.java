package ASM.Operand;

public class VirtualReg extends ASMRegister{
    public String Identifier;
    public PhysicalReg Allocated_Reg;
    public VirtualReg(String Identifier,PhysicalReg Allocated_Reg){
        this.Allocated_Reg = Allocated_Reg;
        this.Identifier = Identifier;

    }
    public VirtualReg(String Identifier){
        this.Identifier = Identifier;
    }
    @Override
    public String toString(){
        if(Allocated_Reg ==null) return "[v]"+Identifier;
        else return Allocated_Reg.toString();
    }
}
