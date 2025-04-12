/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class NormalizeTextController {
    FormatText fmText = new FormatText();
    
    public void readTextFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        if (file.exists() && file.isFile()) {
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                bufferedReader.close();
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    public void NormalizeText() throws IOException {
        BufferedReader br = null;
        try {
            int countLine = fmText.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
            String line;
            //write until end file
            while ((line = br.readLine()) != null) {
                //check line empty
                if (fmText.isLineEmpty(line)) {
                    continue;
                }
                line = fmText.formatOneSpace(line);
                line = fmText.formatSpecialCharacters(line);
                line = fmText.afterDotUpperCase(line);
                line = fmText.noSpaceQuotes(line);
                line = fmText.firstUpercase(line);
                line = fmText.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful as output.txt.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
