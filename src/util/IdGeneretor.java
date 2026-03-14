package util;

public class IdGeneretor {
    public static synchronized String generate(String v, int number){
        return v + number;
    }
}
