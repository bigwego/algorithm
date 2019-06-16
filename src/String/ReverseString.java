package String;

public class ReverseString {

    public void reverseString(char[] chs) {
        int left = 0;
        int right = chs.length - 1;
        while (left < right) {
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
    }
}
