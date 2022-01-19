package MIR;
import Util.ArrayType;

import java.util.ArrayList;
import java.util.HashMap;
public class IRModule {
    public static BaseType string_tp = new PointerType(new IntType(8));
    public HashMap<String,IRFunction> Funcs;
    public HashMap<String,IRFunction> Sys_Funcs;
    public HashMap<String,GlobalReg> GlobalRegs;
    public HashMap<String,GlobalReg> StringConsts;
    public HashMap<String,IRClassType> ClassMap;
    public IRModule() {
        Funcs = new HashMap<String,IRFunction>();
        GlobalRegs = new HashMap<String,GlobalReg>();
        StringConsts = new HashMap<String,GlobalReg>();
        ClassMap = new HashMap<String,IRClassType>();
        Sys_Funcs = new HashMap<String,IRFunction>();
        //void print(string str);
        ArrayList<Parameter> para_pr = new ArrayList<Parameter>();
        para_pr.add(new Parameter(new PointerType(new IntType(8)),"str"));
        IRFunction str_func = new IRFunction("mx_print",this,para_pr,new VoidType(),true);
        Sys_Funcs.put("mx_print",str_func);
        //void println(string str);
        ArrayList<Parameter> para_println = new ArrayList<Parameter>();
        para_println.add(new Parameter(new PointerType(new IntType(8)),"str"));
//        System.out.println(para_println.size());
        IRFunction println_func = new IRFunction("mx_println",this,para_println,new VoidType(),true);
        Sys_Funcs.put("mx_println",println_func);
        //void printInt(int n);
        ArrayList<Parameter> para_printInt = new ArrayList<Parameter>();
        para_printInt.add(new Parameter(new IntType(32),"n"));
        IRFunction printInt_func = new IRFunction("mx_printInt",this,para_printInt,new VoidType(),true);
        Sys_Funcs.put("mx_printInt",printInt_func);
        //void printlnInt(int n);
        ArrayList<Parameter> para_printlnInt = new ArrayList<Parameter>();
        para_printlnInt.add(new Parameter(new IntType(32),"n"));
        IRFunction printlnInt_func = new IRFunction("mx_printlnInt",this,para_printlnInt,new VoidType(),true);
        Sys_Funcs.put("mx_printlnInt",printlnInt_func);
        //string getString();
        ArrayList<Parameter> para_getString = new ArrayList<Parameter>();
//        para_println.add(new Parameter(new IntType(32),"str"));
        IRFunction getString_func = new IRFunction("mx_getString",this,para_getString,new PointerType(new IntType(8)),true);
        Sys_Funcs.put("mx_getString",getString_func);
        //int getInt();
        ArrayList<Parameter> para_getInt = new ArrayList<Parameter>();
//        para_println.add(new Parameter(new IntType(32),"str"));
        IRFunction getInt_func = new IRFunction("mx_getInt",this,para_getInt,new IntType(32),true);
        Sys_Funcs.put("mx_getInt",getInt_func);
        //string toString(int i);
        ArrayList<Parameter> para_toString = new ArrayList<Parameter>();
        para_toString.add(new Parameter(new IntType(32),"i"));
        IRFunction toString_func = new IRFunction("mx_toString",this,para_toString,new PointerType(new IntType(8)),true);
        Sys_Funcs.put("mx_toString",toString_func);
        //malloc(size)
        ArrayList<Parameter> para_malloc = new ArrayList<>();
        para_malloc.add(new Parameter(new IntType(32),"SizeOfMalloc"));
        IRFunction malloc_func = new IRFunction("mx_malloc",this,para_malloc,new PointerType(new IntType(8)),true);
        Sys_Funcs.put("mx_malloc",malloc_func);
        //String StringAdd(a,b)
        ArrayList<Parameter> para_StringAdd = new ArrayList<>();
        para_StringAdd.add(new Parameter(string_tp,"a"));
        para_StringAdd.add(new Parameter(string_tp,"b"));
        IRFunction StringAdd_func = new IRFunction("mx_str_add",this,para_StringAdd,string_tp,true);
        Sys_Funcs.put("mx_str_add",StringAdd_func);
        //String Stringlt(a,b)
        ArrayList<Parameter> para_Stringlt = new ArrayList<>();
        para_Stringlt.add(new Parameter(string_tp,"a"));
        para_Stringlt.add(new Parameter(string_tp,"b"));
        IRFunction Stringlt_func = new IRFunction("mx_string_lt",this,para_Stringlt,new IntType(1),true);
        Sys_Funcs.put("mx_string_lt",Stringlt_func);
        //String Stringgt(a,b)
        ArrayList<Parameter> para_Stringgt = new ArrayList<>();
        para_Stringgt.add(new Parameter(string_tp,"a"));
        para_Stringgt.add(new Parameter(string_tp,"b"));
        IRFunction Stringgt_func = new IRFunction("mx_string_gt",this,para_Stringgt,new IntType(1),true);
        Sys_Funcs.put("mx_string_gt",Stringgt_func);
        //String Stringge(a,b)
        ArrayList<Parameter> para_Stringge = new ArrayList<>();
        para_Stringge.add(new Parameter(string_tp,"a"));
        para_Stringge.add(new Parameter(string_tp,"b"));
        IRFunction Stringge_func = new IRFunction("mx_string_ge",this,para_Stringge,new IntType(1),true);
        Sys_Funcs.put("mx_string_ge",Stringge_func);
        //String Stringle(a,b)
        ArrayList<Parameter> para_Stringle = new ArrayList<>();
        para_Stringle.add(new Parameter(string_tp,"a"));
        para_Stringle.add(new Parameter(string_tp,"b"));
        IRFunction Stringle_func = new IRFunction("mx_string_le",this,para_Stringle,new IntType(1),true);
        Sys_Funcs.put("mx_string_le",Stringle_func);
        //String Stringeq(a,b)
        ArrayList<Parameter> para_Stringeq = new ArrayList<>();
        para_Stringeq.add(new Parameter(string_tp,"a"));
        para_Stringeq.add(new Parameter(string_tp,"b"));
        IRFunction Stringeq_func = new IRFunction("mx_string_eq",this,para_Stringeq,new IntType(1),true);
        Sys_Funcs.put("mx_string_eq",Stringeq_func);
        //String Stringne(a,b)
        ArrayList<Parameter> para_Stringne = new ArrayList<>();
        para_Stringne.add(new Parameter(string_tp,"a"));
        para_Stringne.add(new Parameter(string_tp,"b"));
        IRFunction Stringne_func = new IRFunction("mx_string_ne",this,para_Stringne,new IntType(1),true);
        Sys_Funcs.put("mx_string_ne",Stringne_func);
        //String StringLength(a)
        ArrayList<Parameter> para_StringLength = new ArrayList<>();
        para_StringLength.add(new Parameter(string_tp,"a"));
        IRFunction StringLength_func = new IRFunction("mx_string_length",this,para_StringLength,new IntType(32),true);
        Sys_Funcs.put("mx_string_length",StringLength_func);
        //String StringSubstring(a,l,r)
        ArrayList<Parameter> para_StringSubstring = new ArrayList<>();
        para_StringSubstring.add(new Parameter(string_tp,"a"));
        para_StringSubstring.add(new Parameter(new IntType(32),"l"));
        para_StringSubstring.add(new Parameter(new IntType(32),"r"));
        IRFunction StringSubstring_func = new IRFunction("mx_string_substring",this,para_StringSubstring,string_tp,true);
        Sys_Funcs.put("mx_string_substring",StringSubstring_func);
        //String StringParseInt(a)
        ArrayList<Parameter> para_StringParseInt = new ArrayList<>();
        para_StringParseInt.add(new Parameter(string_tp,"a"));
        IRFunction StringParseInt_func = new IRFunction("mx_string_parseInt",this,para_StringParseInt,new IntType(32),true);
        Sys_Funcs.put("mx_string_parseInt",StringParseInt_func);
        //String StringOrd(a)
        ArrayList<Parameter> para_StringOrd = new ArrayList<>();
        para_StringOrd.add(new Parameter(string_tp,"a"));
        para_StringOrd.add(new Parameter(new IntType(32),"pos"));
        IRFunction StringOrd_func = new IRFunction("mx_string_ord",this,para_StringOrd,new IntType(32),true);
        Sys_Funcs.put("mx_string_ord",StringOrd_func);
        //////////////////////////////////////
        IRFunction Init = new IRFunction("_init_",this,new ArrayList<>(),new VoidType(),false);
        Funcs.put("_init_",Init);
    }
    public void addFunction(IRFunction func) {
        Funcs.put(func.id, func);
    }
    public GlobalReg addStringConst(String str) {
        str = str.replace("\\\\", "\\");
        str = str.replace("\\n", "\n");
            str = str.replace("\\\"", "\"");
        str = str + "\0";
        if (StringConsts.containsKey(str)) {
            return StringConsts.get(str);
        } else {
            StringConst Str = new StringConst(str,new IRArrayType( str.length(),new IntType(8)));
            GlobalReg thisreg = new GlobalReg(Str,null, ".str." + StringConsts.size(),new PointerType(new IRArrayType( str.length(),new IntType(8))));
            StringConsts.put(str, thisreg);
            GlobalRegs.put(thisreg.id,thisreg);
            return thisreg;
        }
    }
}
