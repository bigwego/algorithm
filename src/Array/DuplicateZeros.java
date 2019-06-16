package Array;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int idx = 0, len = arr.length;

        while (idx < len - 1) {
            if (arr[idx] == 0) {
                for (int i = len - 1; i >= idx + 1; i--)
                    arr[i] = arr[i - 1];
                arr[idx + 1] = 0;
                idx += 2;
            }else {
                idx++;
            }
        }
    }
}
