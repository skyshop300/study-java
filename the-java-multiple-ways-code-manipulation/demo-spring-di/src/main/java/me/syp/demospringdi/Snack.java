package me.syp.demospringdi;

public class Snack {
    public static String a = "stringA";
    private String b = "stringB";

    public Snack() {

    }

    public Snack(String b) {
        this.b = b;
    }

    public void c()     {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }

}
