package man.kuke.transaction.demo;

import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("输入学号：");
        String id = in.nextLine();

        System.out.println("输入姓名：");
        String name = in.nextLine();

        Student student = new Student(id,name);

    }
}
