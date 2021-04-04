package org.example;

//Написать функцию, вычисляющую площадь треугольника по трем сторонам (int a, int b, int c). Разместить класс с функцией в src/main/java
//     Разместить тесты на эту функцию в классе src/test/java/.../TriangleTest.java
//   Настроить генерацию отчета и - по желанию - логирование.


public class Triangle {
    private int a, b, c;

    public Triangle(int sideA, int sideB, int sideC) {
        this.a = sideA;
        this.b = sideB;
        this.c = sideC;
    }

    public double function() {
        double a1 = a;
        double b1 = b;
        double c1 = c;

        if (a1 < 0 || b1 < 0 || c1 < 0) {
            System.out.println("Значение должно быть больше 0");
            return 0;
        }

        if (a1 >= b1 + c1 || c1 >= b1 + a1 || b1 >= a1 + c1) {
            System.out.println("Эти стороны не образуют треугольника");
            return 0;
        }
        double p = (a1 + b1 + c1) / 2;

        return p;
    }

    public boolean square(double p) {
        double a1 = a;
        double b1 = b;
        double c1 = c;

        double s = (double) Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
        return s != 0;
    }

    public static void main(String[] args) {

        Triangle tr = new Triangle(22, 23, 42);
        Triangle tr1 = new Triangle(2, 4, 6);
        Triangle tr2 = new Triangle(-22, 23, 42);

        double p;
        p = tr.function();
        System.out.println(tr.square(p));

        p = tr1.function();
       System.out.println(tr1.square(p));

        p = tr2.function();
        System.out.println(tr2.square(p));
    }
}



