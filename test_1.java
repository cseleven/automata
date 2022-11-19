
import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test_1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Open the file
        FileInputStream fstream = new FileInputStream("D:/automata/fileName.txt");
        // "src/lexical/analizer/textfile"
        // "C:\Users\jee38\OneDrive\Documents\automata\fileName.txt"
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<String> linesA = new ArrayList<String>();
        ArrayList<String> identifier = new ArrayList<String>();
        System.out.println("identifier " + identifier.size());

        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {

            linesA.add(strLine);
            System.out.print("strLine " + strLine);

        }

        System.out.println();
        // Close the input stream

        br.close();

        for (int j = 0; j < linesA.size(); j++) {

            if (Pattern.matches("\"[^\"]*\"", linesA.get(j))) {
                System.out.println("String : " + linesA.get(j));
                linesA.remove(j);

            } else if (linesA.get(j).contains("/*") && linesA.get(j).contains("*/") || linesA.get(j).contains("//")) {
                System.out.println("comments : " + linesA.get(j));
                linesA.remove(j);

            }

        }

        for (String line : linesA) {

            lines.addAll(Arrays.asList(line.split("\\s")));
            // Collections.addAll(lines, line.split("\\s"));
        }

        for (int i = 0; i < lines.size(); i++) {
            int k = 0;

            if (lines.get(i).equals("+") || lines.get(i).equals("-") || lines.get(i).equals("*")
                    || lines.get(i).equals("/") || lines.get(i).equals("=") || lines.get(i).equals(">")
                    || lines.get(i).equals(">=") || lines.get(i).equals("<") || lines.get(i).equals("<=")
                    || lines.get(i).equals("==") || lines.get(i).equals("++") || lines.get(i).equals("--")) {
                System.out.println("operator : " + lines.get(i));

            } else if (lines.get(i).equals("(") || lines.get(i).equals(")") || lines.get(i).equals("()")) {
                System.out.println("bracket : " + lines.get(i));

            } else if (lines.get(i).equals(";")) {
                System.out.println("semicolon : " + lines.get(i));

            } else if (lines.get(i).equals("if") || lines.get(i).equals("then") || lines.get(i).equals("else")
                    || lines.get(i).equals("endif")
                    || lines.get(i).equals("while") || lines.get(i).equals("do")
                    || lines.get(i).equals("endwhile")
                    || lines.get(i).equals("print") || lines.get(i).equals("newline")
                    || lines.get(i).equals("read")) {
                System.out.println("keywords : " + lines.get(i));

            } else if (Pattern.matches("[0-9]*", lines.get(i))) {
                System.out.println("integers : " + lines.get(i));

            } else if (Pattern.matches("\\b[_a-zA-Z][_a-zA-Z0-9]*\\b", lines.get(i))) {// ^([a-zA-Z_$][a-zA-Z\\d_$]*)$

                if (identifier.size() != 0) {

                    for (int l = 0; l < identifier.size() + 1; l++) {

                        switch(lines.get(i)){
                            case !=identifier.get(l) :
                        }

                        
                    System.out.println("new identifier : " + lines.get(i));
                        identifier.add(lines.get(i));
                }
                } else {

                    System.out.println("new identifier : " + lines.get(i));
                    identifier.add(lines.get(i));

                }
            } /*
               * else if (Pattern.matches("\"[^\"]*\"", linesA.get(i))) {
               * System.out.println("String : " + linesA.get(i));
               * 
               * } else if (linesA.get(i).contains("/*") && linesA.get(i).contains("")) {
               * System.out.println("comments : " + linesA.get(i));
               * 
               * } else if (Pattern.matches("(?s)/\\*(.)*?\\*", linesA.get(i))) {
               * System.out.println("comments : " + linesA.get(i));
               */

            else {
                System.out.println("error : " + lines.get(i));
            }

        }
        for (int j = 0; j < identifier.size(); j++) {
            System.out.print(identifier.get(j) + " ");
        }

    }
}
