package exceptions;

public class NPEx {
    public static void main(String[] args) {
        String[] shops = new String[5];
        shops[0] = "ItalModa";
        for (int i = 0; i < shops.length; i++) {
            /*String el = shops[i];
            System.out.println(el + " has size : " + el.length());
        }*/
        /*Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because
        "el" is null at exceptions.NPEx.main(NPEx.java:9)*/
            String el = shops[i];
            if (el != null) {
                System.out.println(el + " has a size : " + el.length());
            }
            //now it works correct because block if checked != null
        }
    }
}