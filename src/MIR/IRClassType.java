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
    public int CalcSize() {
        int sum=0;
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
    @Override public int size() {
        return 0;
    }
    @Override public operand defaultval() {
        return null;
    }
}
