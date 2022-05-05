package Easy;
public class roman_to_int {
    public static void main(String[] args) {
        String s = "XXVII";
        roman_to_int obj = new roman_to_int();
        System.out.println(obj.romanToInt(s));
    }

    public int getIntger(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return -1;
        }
    }
    public int romanToInt(String s) {
        roman_to_int fun_obj = new roman_to_int();
        int n = s.length(), results = 0, current, next, i=0;
        System.out.println("Length of string: " + n);
        while (i < n) { // if i < n keep looping
            if (i == n -1) { // end of string. Since i starts at zero. We must subtract our n length by 1
                results += fun_obj.getIntger(s.charAt(i));
                System.out.println("RESULTS: " + results);
                return results;
            }
            /* Get current and next value */
            current = fun_obj.getIntger(s.charAt(i));
            next = fun_obj.getIntger(s.charAt(i + 1));

            if (current >= next) { // if current is >= next. Then add to current to results
                results += current;
                i++;
            }
            else { // Otherwise subtract next - current and increment i 2 places.
                results += next - current;
                i += 2;
            }
        }
        return results;

    }


}