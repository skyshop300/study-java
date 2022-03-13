package me.syp.demospringdi;

@MyAnnotation(value="sungyong")
public class Snack {
    private String a = "stringA";
    private String b = "stringB";
    public String c = "stringC";
    protected String d = "stringD";

    public Snack() {

    }

    public Snack(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private void f() {

    }

    public void g() {

    }

    public void h() {

    }
}
