import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }

        list.add(new ArrayList<>());
        list.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(1);
            List<Integer> prelist = list.get(i - 1);

            for (int j = 1; j < i; j++) {
                sublist.add(prelist.get(j) + prelist.get(j - 1));
            }
            sublist.add(1);
            list.add(sublist);
        }

        return list;

    }
}
