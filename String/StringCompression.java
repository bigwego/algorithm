class StringCompression {
    public int compress(char[] chars) {
        int rec_idx = 0, idx = 0, len = chars.length;
        while (idx < len) {
            char curr = chars[idx++];
            int cnt = 1;
            while(idx<len&&chars[idx]==curr){
                idx++;
                cnt++;
            }
            chars[rec_idx++] = curr;
            if(cnt>1) {
                for(char c: Integer.toString(cnt).toCharArray())
                    chars[rec_idx++] = c;
            }
        }
        return rec_idx;
    }
}
