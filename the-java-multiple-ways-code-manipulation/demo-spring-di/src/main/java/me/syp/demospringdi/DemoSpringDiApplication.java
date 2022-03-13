package me.syp.demospringdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@SpringBootApplication
public class DemoSpringDiApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(DemoSpringDiApplication.class, args);

        /* 리플렉션을 통해 여러가지 정보를 참조 및 변경할 수 있다. */
        Class<Snack> snackClass = Snack.class;  // Class 타입의 인스턴스를 가져옴
        // ++ Class 타입의 로딩 -> HEAP에 넣어준다.

        Snack snack = new Snack();
        Class<? extends Snack> aClass = snack.getClass();
        Class<?> aClass1 = Class.forName("me.syp.demospringdi.Snack");  // class

        System.out.println("[getFields]");
        Arrays.stream(snackClass.getFields()).forEach(System.out::println);         // getFields(): public 접근제어자만 가져온다.
        System.out.println("[getDeclaredFields]");
        Arrays.stream(snackClass.getDeclaredFields()).forEach(System.out::println); // getDeclaredFields(): 접근제어자에 상관없이 가져온다.

        System.out.println("[getDeclaredFields] 접근제어자 무력화");                    // 무력화하지 않으면 IllegalAccessException이 발생한다.
        Arrays.stream(snackClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);  // 접근제어자 무력화 - Reflection은 접근제어자를 무시하여 정보를 가져올 수 있다.
                System.out.printf("%s %s\n ", f, f.get(snack));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("[getMethods]");
        Arrays.stream(snackClass.getMethods()).forEach(System.out::println);
        System.out.println("[getConstructors]");
        Arrays.stream(snackClass.getConstructors()).forEach(System.out::println);
        System.out.println("[getInterfaces]");
        Arrays.stream(snackClass.getInterfaces()).forEach(System.out::println);

        System.out.println("[getSuperclass]");
        System.out.println(snackClass.getSuperclass());

        System.out.println("[getFields]");
        Arrays.stream(snackClass.getFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println("modifiers:" + modifiers);
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        /*
         * [1] Annotation
         * Annotation은 조회가 되지 않는다.
         * Annotation은 주석과 동일한 취급을 받는다.
         * ByteCode를 Loading 했을 떄에는 Annotation 정보를 제외한다.
         * annotation
         */

        // Annotation은 조회가 되지 않는다.
        //
        //
        System.out.println("[getAnnotations]");
        System.out.println("[getAnnotations]");
        Arrays.stream(MySnack.class.getAnnotations()).forEach(System.out::println);
    }
}
