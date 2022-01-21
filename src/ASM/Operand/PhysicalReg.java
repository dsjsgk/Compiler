package ASM.Operand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhysicalReg extends ASMRegister{
    public enum type {
        caller,callee,ptr,zero
    }
    public static ArrayList<String> Name = new ArrayList<>(
            Arrays.asList("zero","ra","sp","gp","tp","t0","t1","t2","s0","s1","a0","a1","a2","a3","a4","a5","a6","a7",
                    "s2","s3","s4","s5","s6","s7","s8","s9","s10","s11","t3","t4","t5","t6")
    );
    public static ArrayList<type> Type = new ArrayList<>(
            Arrays.asList(type.zero,type.caller,type.ptr,type.ptr,type.ptr,type.caller,type.caller,type.caller,type.callee,type.callee,
                    type.caller, type.caller, type.caller, type.caller, type.caller, type.caller, type.caller, type.caller,
                    type.callee, type.callee, type.callee, type.callee, type.callee, type.callee, type.callee, type.callee, type.callee, type.callee,
                    type.caller, type.caller, type.caller, type.caller)
    );

    public static HashMap<String,PhysicalReg> phyMap = new HashMap();
    public static HashMap<String,VirtualReg> virMap = new HashMap();

    static public void Init() {
        for(int i=0;i<Name.size();++i) {
            phyMap.put(Name.get(i),new PhysicalReg(Name.get(i),Type.get(i),i));
            virMap.put(Name.get(i),new VirtualReg(Name.get(i),phyMap.get(Name.get(i))));
        }
    }
    static public VirtualReg getv(String id) {
//        System.out.println(virMap.containsKey("s0"));
        return virMap.get(id);
    }
    static public PhysicalReg getp(String id) {
        return phyMap.get(id);
    }
    public String Identifier;
    public type thistype;
    public int Num;
    public PhysicalReg(String Identifier,type thistype,int Num) {
        this.Identifier = Identifier;
        this.thistype = thistype;
        this.Num = Num;
    }
    @Override
    public String toString(){
        return Identifier;
    }
}
