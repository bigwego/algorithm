public class Flatten2DVector implements Iterator<Integer> {

    List<List<Integer>> list;
        int elementIdx, listIdx;

        public Flatten2DVector(List<List<Integer>> vec2d) {
            list = vec2d;
            elementIdx = 0;
            listIdx = 0;
        }

        @Override
        public Integer next() {
            return list.get(listIdx).get(elementIdx++);
        }

        @Override
        public boolean hasNext() {
            if (list == null || list.size() == 0) {
                return false;
            }
            if (elementIdx == list.get(listIdx).size()) {
                elementIdx = 0;
                listIdx++;
            }
            while (listIdx < list.size() && list.get(listIdx).size() == 0) {
                listIdx++;
            }
            return listIdx != list.size();
        }

        @Override
        public void remove() {

        }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
