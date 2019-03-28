/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharactersGivenRead4II extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    char[] buffer = new char[4];
    int head = 0, tail = 0;

	public int read(char[] buf, int n) {
		int idx = 0;
		while (idx < n) {
			if (head == tail) {
			    head = 0;
				tail = read4(buffer);
				if (tail == 0) {
					break;
				}
			}
			while (idx < n && head < tail) {
				buf[idx++] = buffer[head++];
			}
		}
		return idx;
	}
}
