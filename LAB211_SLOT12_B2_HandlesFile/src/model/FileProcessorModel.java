
package model;

import Person.Person;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileProcessorModel {
    public List<Person> getPerson(String path, double money) throws Exception {
        List<Person> people = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) {
            throw new Exception("Path doesn't exist");
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                String name = parts[0];
                String address = parts[1];
                double salary = 0;
                try {
                    salary = Double.parseDouble(parts[2]);
                } catch (NumberFormatException e) {
                }
                people.add(new Person(name, address, salary));
            }
        } catch (FileNotFoundException e) {
            throw new Exception("Can’t read file");
        }

        Collections.sort(people, Comparator.comparingDouble(Person::getSalary));

        return people;
    }

    public boolean copyWordOneTimes(String source, String destination) throws Exception {
        Set<String> uniqueWords = new HashSet<>();
        File sourceFile = new File(source);
        File destFile = new File(destination);

        if (!sourceFile.exists()) {
            throw new Exception("Source file doesn't exist");
        }

        try (Scanner scanner = new Scanner(sourceFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    uniqueWords.add(word);
                }
            }

            for (String word : uniqueWords) {
                writer.write(word);
                writer.newLine();
            }

            return true;
        } catch (FileNotFoundException e) {
            throw new Exception("Can’t read source file");
        } catch (IOException e) {
            throw new Exception("Can’t write destination file");
        }
    }
}
