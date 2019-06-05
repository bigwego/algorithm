package String;

public class LegalIdentifier {

    public boolean isLegalIdentifier(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        if (Character.isDigit(str.charAt(0))) {
            return false;
        }

        for(char c:str.toCharArray()){
            if(c!='_'&&!Character.isDigit(c)&&!Character.isAlphabetic(c)){
                return false;
            }
        }

        return true;
    }
}
