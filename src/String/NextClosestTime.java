public class NextClosestTime {
    
    public static String nextCloestTime(String time) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (!list.contains(time.charAt(i)))
                list.add(time.charAt(i));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder(time);
        for (int i = 4; i > -1; i--) {
            if (i == 2) {
                sb.append(":");
                continue;
            }
            int idx = list.indexOf(time.charAt(i));
            if (idx == list.size() - 1) sb.setCharAt(i,list.get(0));
            else {
                char next = list.get(idx + 1);
                if (i == 4) {
                    sb.setCharAt(i,next);
                    break;
                } else if (i == 3 && next <= '5') {
                    sb.setCharAt(i,next);
                    break;
                } else if (i == 1 && (time.charAt(0) != '2' || (time.charAt(0) == '2' && next <= '3'))) {
                    sb.setCharAt(i,next);
                    break;
                } else if (i == 0 && next <= '2') {
                    sb.setCharAt(i,next);
                    break;
                } else sb.setCharAt(i,list.get(0));
            }
        }
        return sb.toString();
    }
}
