/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Person;
import Model.Validate;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class PersonInfoController {

    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();

    public Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = validate.checkInputString();
        System.out.print("Please input address: ");
        String address = validate.checkInputString();
        System.out.print("Please input salary: ");
        double salary = validate.checkInputSalary();
        return new Person(name, address, salary);
    }

    public void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.getSalary() > listPersonWrapper[j].p.getSalary()) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        return;
    }

    public void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    public void define() {
        System.out.print("Enter number of Person: ");
        int n = sc.nextInt();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        sortBySalary(persons, listPersonWrapper);
        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i].p.displayPersonInfo();
        }
    }
}
