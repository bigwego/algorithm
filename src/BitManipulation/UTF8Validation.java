package BitManipulation;

public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        for (int i = 0, len = data.length; i < len; ) {
            if (data[i] > 255) {
                return false;
            }
            int jump = 0;
            if ((data[i] & 128) == 0) {
                jump = 1;
            } else if ((data[i] & 224) == 192) {
                jump = 2;
            } else if ((data[i] & 240) == 224) {
                jump = 3;
            } else if ((data[i] & 248) == 240) {
                jump = 4;
            } else {
                return false;
            }
            if (i + jump > len) {
                return false;
            }
            for (int j = 1; j < jump; j++) {
                if ((data[i + j] & 192) != 128) {
                    return false;
                }
            }
            i += jump;
        }
        return true;
    }

    public boolean validUtf82(int[] data) {
        for (int i = 0, len = data.length; i < len; i++) {
            int d = data[i];
            if (d > 255) return false;
            int jump = 0;
            if ((d & 128) == 0) jump = 0;
            else if ((d & 224) == 192) jump = 1;
            else if ((d & 240) == 224) jump = 2;
            else if ((d & 248) == 240) jump = 3;
            else return false;
            if (i + jump > len) return false;
            while (jump-- > 0) {
                i++;
                if ((data[i] & 192) != 128) return false;
            }
        }

        return true;
    }
}
