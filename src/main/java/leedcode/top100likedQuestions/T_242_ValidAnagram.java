package leedcode.top100likedQuestions;

public class T_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sa = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int idx = t.indexOf(current);
            if (idx == -1) {
                return false;
            } else {
                t = t.substring(0, idx) + t.substring(idx + 1);

            }
        }
        return true;

    }

//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//
//        for(int i = 0; i < s.length(); i++){
//            char current = s.charAt(i);
//            int idx = t.indexOf(current);
//            if(idx == -1){
//                return false;
//            }else{
//                t = t.substring(0, idx) + t.substring(idx+1);
//
//            }
//        }
//        return true;
//
//    }
}
