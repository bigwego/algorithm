public class ReverseWordsInAStringII {
        /**
         * @param str: a string
         * @return: return a string
         */
        public char[] reverseWords(char[] str) {
            reverse(str, 0, str.length - 1);
            int i = 0;
            for (int j = 1; i < str.length && j < str.length; j++) {
                while (j < str.length && str[j] != ' ') {
                    j++;
                }
                reverse(str, i, j - 1);
                i = j + 1;
            }
            return str;
        }

        private void reverse(char[] str, int i, int j) {
            while (i < j) {
                char temp = str[i];
                str[i++] = str[j];
                str[j--] = temp;
            }
        }
    }
