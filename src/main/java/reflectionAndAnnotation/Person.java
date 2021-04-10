package reflectionAndAnnotation;

/**
 * @program: maven_1
 * @description:
 * @author: Erebus
 * @create: 2021-03-29 19:14
 */
public class Person implements Showable{
    private String name;
    private int age;

    public Person(){
        System.out.println("无参的构造方法");
    }
    public Person(String name) {
        this.name = name;
        System.out.println("有参的构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是Person里的show");
    }
}
