package effectivejava.item10;

import java.util.Objects;

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /**
     * Brokes symmetry!!!!!
     * {@link CaseInsensitiveString} knows about comparition but String does not
     * @param o
     * @return
     */
    public boolean equalsBad(Object o) {
        if(o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if(o instanceof String){
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    public boolean equalsGood(Object o) {
       return o instanceof CaseInsensitiveString &&
               ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }


}
