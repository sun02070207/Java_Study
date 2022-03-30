package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-10:25
*/

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 561569749143L;

    private String name;
    private int age;
    private Account balance;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public Account getBalance() {
        return balance;
    }

    public void setBalance(Account balance) {
        this.balance = balance;
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
                ", balance=" + balance +
                '}';
    }
}

class Account implements Serializable{
    private static final long serialVersionUID = 1646342342462463l;
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}