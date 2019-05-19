package String;

public class CheckIfWordIsValidAfterSubstitutions {

    public boolean isValid(String S) {
        if (S.equals("abc")) {
            return true;
        }
        int idx = S.indexOf("abc");
        return idx == -1 ?
                false : isValid(S.substring(0, idx) + S.substring(idx + 3));
    }
}
