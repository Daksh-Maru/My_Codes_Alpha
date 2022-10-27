public class OOPS {
    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.setColor("Blue");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // p1.setColor("Yellow");
        // //p1.color = "Yellow";
        // System.out.println(p1.getColor());



        // BankAccount myAcc = new BankAccount();
        // myAcc.username = "Daksh Maru";
        // myAcc.setPwd("asdfghjkl");



        // Student s1 = new Student();
        // s1.name = "Daksh";
        // s1.roll = 456;
        // s1.password = "abcd";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;
        
        // Student s2 = new Student(s1);
        // s2.password = "qwe";
        // s1.marks[2] = 100;
        // for (int i=0; i<3; i++) {
        //     System.out.print(s2.marks[i] + " ");
        // }
        


        // Fish shark = new Fish();
        // shark.eat();
        // shark.breathe();
        // shark.swim();
        // Dog dobby = new Dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);
        
        // Bird parrot = new Bird();
        // parrot.fly();
        

        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(1, 2));
        // System.out.println(calc.sum((float)1.3, (float)2.4));
        // System.out.println(calc.sum(1, 2, 5));

        
        // Deer d1 = new Deer();
        // d1.eat();


        // Horse h = new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        // chicken c = new chicken();
        // c.eat();
        // c.walk();
        // Mustang myh = new Mustang();

        // Bear b = new Bear();
        // b.eats();

        
        Student s1 = new Student();
        s1.schoolName = "JMV";

        Student s2 = new Student();
        System.out.println(s2.schoolName);
    }
}

class Student {
    String name;
    int roll;
    static String schoolName;
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}



interface Herbivore {
    void eats();
}
interface Carnivore {
    void eats();
}
class Bear implements Herbivore, Carnivore {
    public void eats() {
        System.out.println("eats grass and meat");
    }
}



abstract class Animal {
    String color;   
    Animal() {
        System.out.println("animal constructor called");
    }
    void eat() {
        System.out.println("animal eats");
    }

    abstract void walk();
}
class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called");
    }
    void changeColor() {
        color = "white";
    }
    void walk() {
        System.out.println ("walks on 4 legs");
    }
}
class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
}
class chicken extends Animal {
    void walk() {
        System.out.println ("walks on 2 legs");
    }
}




class Animals {
    void eat() {
        System.out.println("eats anything");
    }
}
class Deer extends Animals {
    void eat() {
        System.out.println("eats grass");
    }
}



//METHOD OVERLOADING
class Calculator {
    int sum (int a, int b) {
        return a+b;
    }
    float sum (float a, float b) {
        return a+b;
    }
    int sum (int a, int b, int c) {
        return a+b+c;
    }
}


// INHERITENCE
// class Animal {
//     String color;
//     void eat() {
//         System.out.println("eats");
//     }

//     void breathe() {
//         System.out.println("breathes");
//     }
// }
// // class Fish extends Animal {
// //     int fins;
// //     void swim() {
// //         System.out.println("swims in water.");
// //     }
// // }
// class Mammal extends Animal {
//     void walk() {
//         System.out.println("walks");
//     }
// }
// class Fish extends Animal {
//     void swim() {
//         System.out.println("swims");
//     }
// }
// class Bird extends Animal {
//     void fly() {
//         System.out.println("flies");
//     }

// }






//CONSTRUCTORS.
// class Student {
//     String name;
//     int roll;
//     String password;
//     int marks[];

//     //SHALLOW COPY CONST.
//     // Student(Student s1) {
//     //     marks = new int[3];
//     //     this.name = s1.name;
//     //     this.roll = s1.roll;
//     //     this.marks = s1.marks;
//     // }

//     //DEEP COPY CONST.
//     Student(Student s1) {
//         marks = new int[3];
//         this.name = s1.name;
//         this.roll = s1.roll;
//         for (int i=0; i<marks.length; i++) {
//             this.marks[i] = s1.marks[i];
//         }
//     }
//     Student() {
//         marks = new int[3];
//         System.out.println("constructor is called..");
//     }
//     Student(String name) {
//         this.name = name;
//     }
//     Student (int roll) {
//         this.roll = roll;
//     }
    
// }





//ACCESS MODIFIRES.
class BankAccount {
    public String username;
    private String password;

    public void setPwd(String pwd) {
        password = pwd;
    }
}





//CLASSES AND OBJECTS.
class Pen {
    String color;
    int tip;

    String getColor() {
        return this.color;
        //jo functin getColor ko call karega wo [this] ko replace kar dega.
    }

    int getTip() {
        return this.tip;
    }
    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newtip) {
        this.tip = newtip;
    }
}
