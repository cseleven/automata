
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

        // ตัวแปร สร้างเพื่อรับจาก textfile
        String strLine;
        // สร้างเพื่อเก็บ String จาก textfile ที่รับจากตัวแปร strLines
        ArrayList<String> beforeSplitlines = new ArrayList<String>();
        // สร้างเพื่อเก็บค่า String จาก 
        ArrayList<String> lines = new ArrayList<String>();

        ArrayList<String> identifier = new ArrayList<String>();
        System.out.println("identifier " + identifier.size());

        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {

            beforeSplitlines.add(strLine);
            System.out.print("strLine " + strLine);

        }

        System.out.println();
        // Close the input stream

        br.close();

        for (int j = 0; j < beforeSplitlines.size(); j++) {

            if (Pattern.matches("\"[^\"]*\"", beforeSplitlines.get(j))) {
                System.out.println("String : " + beforeSplitlines.get(j));
                beforeSplitlines.remove(j);

            } else if (beforeSplitlines.get(j).contains("/*") && beforeSplitlines.get(j).contains("*/")
                    || beforeSplitlines.get(j).contains("//")) {
                System.out.println("comments : " + beforeSplitlines.get(j));
                beforeSplitlines.remove(j);

            }

        }

        for (String line : beforeSplitlines) {

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

                        if (lines.get(i) == identifier.get(l)) {
                            break;
                        }

                        System.out.println("new identifier : " + lines.get(i));
                        identifier.add(lines.get(i));
                    }
                } else {

                    System.out.println("new identifier : " + lines.get(i));
                    identifier.add(lines.get(i));

                }
            } /*
               * else if (Pattern.matches("\"[^\"]*\"", beforeSplitlines.get(i))) {
               * System.out.println("String : " + beforeSplitlines.get(i));
               * 
               * } else if (beforeSplitlines.get(i).contains("/*") &&
               * beforeSplitlines.get(i).contains("")) {
               * System.out.println("comments : " + beforeSplitlines.get(i));
               * 
               * } else if (Pattern.matches("(?s)/\\*(.)*?\\*", beforeSplitlines.get(i))) {
               * System.out.println("comments : " + beforeSplitlines.get(i));
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
