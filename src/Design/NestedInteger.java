package Design;

import java.util.List;

public interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    List<NestedInteger> getList();

    void add(NestedInteger ni);
}