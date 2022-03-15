package me.syp.demospringdi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class DemoSpringDiApplication {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> snackClass = Class.forName("me.syp.demospringdi.Snack");
        // 인스턴스를 만드는 기본적인 방법 Constructor
        // String을 파라메터로 받는 생성자를 가져올 예정
        Constructor<?> constructor = snackClass.getConstructor(String.class);

        // 적절한 파라메터를 설정해준다.
        Snack snack = (Snack) constructor.newInstance("mySnack");
        System.out.println(snack);

        // "a"라는 변수명을 가진 Field를 가져온다.
        Field a = Snack.class.getDeclaredField("a");
        // Field가 특정한 instance에 속해 있는경우 매개변수를 통해 instance를 특정할 수 있다.
        // 현재는 class에 속한 static한 field를 불러오는 것이기 때문에 특정 Object를 설정하지 않는다 (null)
        System.out.println(a.get(null));
        a.set(null, "AAAA");            // 값을 AAAA로 변경한다.
        System.out.println(a.get(null));

        // "b"라는 변수명을 가진 Field를 가져온다.
        Field b = Snack.class.getDeclaredField("b");
        b.setAccessible(true);
        // static하지 않은 field를 불러오는 것이기 때문에
        // instance를 특정해야 가져올 수 있다.
        System.out.println(b.get(snack));
        b.set(snack, "BBBB");            // 값을 BBBB로 변경한다.
        System.out.println(b.get(snack));

        Method c = Snack.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(snack);    // System.out.println("C");

        // getDeclaredMethod("sum"이라는 메소드, 파라미터타입, 파라미터타입);
        Method d = Snack.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) c.invoke(snack, 1,2);
        System.out.println(invoke);
    }
}
