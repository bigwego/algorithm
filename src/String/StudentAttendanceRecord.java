package String;

public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'A') {
                if (cnt == 1) {
                    return false;
                }
                cnt++;
            } else if (chs[i] == 'L') {
                if (i + 2 < chs.length && chs[i + 1] == 'L' && chs[i + 2] == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
}
