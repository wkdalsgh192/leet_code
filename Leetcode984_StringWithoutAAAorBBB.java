import java.util.*;
class StringWithoutAAAorBBB {
    static int h,ht,cnt,ans,arr[];
    public String strWithout3a3b(int a, int b) {
        String str = null;
        if (a>b) str = calc("a","b",a,b);
        else str = calc("b","a",b,a);
        
        return str;
    }
    private static String calc2(String big, String small, int b, int s) {
        String str = null;
        if (b == 2*s) str += String.join("", Collections.nCopies(s, big+big+small));
        else if (b > 2*s) {
        	str = String.join("", Collections.nCopies(s, big+big+small))
        			+ String.join("", Collections.nCopies(b-2*s, big));
    	}
        else {
        	str = String.join("", Collections.nCopies(b-s, big+big+small))
        			+ String.join("", Collections.nCopies(2*s-b, big+small));
        }
        return str;
    }
    private static String calc(String big, String small, int b, int s) {
        String str = null;
        if (b == 2*s) str = IntStream.range(0, s).mapToObj(i -> big+big+small).collect(Collectors.joining(""));
        else if (b > 2*s) {
        	str = IntStream.range(0, s).mapToObj(i -> big+big+small).collect(Collectors.joining("")) 
        			+ IntStream.range(0, 2*b-s).mapToObj(i -> big).collect(Collectors.joining("")) ;
        }
        else {
        	str = IntStream.range(0, b-s).mapToObj(i -> big+big+small).collect(Collectors.joining("")) 
        			+ IntStream.range(0, 2*s-b).mapToObj(i -> big+small).collect(Collectors.joining("")) ;
        }
        return str;
    }
}
