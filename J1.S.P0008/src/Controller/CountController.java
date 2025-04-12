/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Common.Counting;
import Model.Element;
import View.Menu;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class CountController extends Menu<String>{
    static String[] mc = {"Letter and Character count.", "Exit"};
    protected Counting counting;
    protected String s;

    public CountController(Element element) {
        super("COUNTING PROGRAM", mc);
        counting = new Counting();
        s = element.getS();
    }
    
    
    public void execute(int n) {
        switch (n) {
            case 1:
                count();
                break;
            case 2:
                System.exit(0);
        }
    }
    
    public void count(){
        System.out.println("Enter your content:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<String, Integer> characterCounts = Counting.countCharacter(s);
        Counting.displayCharacterCounts(characterCounts);
        Map<Character, Integer> letterCounts = Counting.countLetters(s);
        Counting.displayLetterCounts(letterCounts);
        System.out.println("--------------------------------");
    }
}
