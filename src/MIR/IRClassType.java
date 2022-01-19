package MIR;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class IRClassType extends BaseType{
    public String id;
    public ArrayList<BaseType> member_list;
    public IRClassType(String id,ArrayList<BaseType> member_list) {
        this.id = id;
        this.member_list = member_list;
    }
    public IRClassType(String id) {
        this.id = id;
        member_list = new ArrayList<>();
    }
    public int CalcSize() {
        int sum=0;
       // System.out.println(member_list.size());
        for(int i=0;i<member_list.size();++i) {
            BaseType x=member_list.get(i);
            if (x instanceof IRClassType) sum += (((IRClassType) x).CalcSize());
            else sum+=x.size();
        }
        return sum;
    }

    @Override public String toString () {
        return "%class." + id;
    }
    public String Contruction() {
        StringBuilder ans = new StringBuilder();
        ans.append(toString());
        ans.append(" = type { ");
        for(int i=0;i<member_list.size();++i) {
            ans.append(member_list.get(i).toString());
            if(i!=member_list.size()-1) ans.append(",");
            else ans.append(" }");
        }return ans.toString();
    }
    @Override public int size() {
        return 0;
    }
    @Override public operand defaultval() {
        return null;
    }
}
