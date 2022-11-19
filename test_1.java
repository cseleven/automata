
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
        FileInputStream fstream = new FileInputStream("D:/New folder/automata/fileName.txt");
        // "src/lexical/analizer/textfile"
        // "C:\Users\jee38\OneDrive\Documents\automata\fileName.txt"
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        // ตัวแปร สร้างเพื่อรับจาก textfile
        String strLine;
        String stringA;

        // สร้างเพื่อเก็บ String จาก textfile ที่รับจากตัวแปร strLines
        ArrayList<String> beforeSplitlines = new ArrayList<String>();

        // สร้างเพื่อเก็บค่า String จาก หลังจาก split ข้อมูลออกมาจาก อาเรย์
        // beforeSplitlines(ข้อมูลบรรทัดเดียวกันมันมีเว้นวรรคทำให้มันอ่านและเก็บค่าเป็นบรรทัดไม่ได้เป็นคำๆไป)
        ArrayList<String> lines = new ArrayList<String>();

        // สร้างเพื่อเก็บค่า textfile ที่มีค่าเป็น identifierตามโจทย์อาจารย์
        // ห้านมันซ้ำกัน (จะเอามันไปloopเช็คว่าซ้ำไหม)
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

        // ใช้เช็คตัวที่เป็น String กับคอมเม้นตามโจทย์อาจารย์
        for (int j = 0; j < beforeSplitlines.size(); j++) {

            // ถ้าค่าที่ตรวจมีลักษณะเป็น /* // */ จะแสดงผลเป็น comments : ค่าที่ตรวจ
            if (beforeSplitlines.get(j).contains("/*") && beforeSplitlines.get(j).contains("*/")
                    || beforeSplitlines.get(j).contains("//")) {
                //System.out.println("comments : " + beforeSplitlines.get(j));

                // ถ้าค่าที่ตรวจมีลักษณะเป็น ข้อความ จะแสดงผลเป็น string : ค่าที่ตรวจ
            } else if (Pattern.matches("\"[^\"]*\"", beforeSplitlines.get(j))) {
                
                System.out.println("String : " + beforeSplitlines.get(j));
                beforeSplitlines.remove(j);
                
            }

        }

        // ใช้ split เอาวรรคออกแล้วเก็บค่าตัวแปรเป็นตัวๆ จากอาเรย์ beforeSplitlines
        // เก็บไว้ในอาเรย์ lines
        for (String line : beforeSplitlines) {
            lines.addAll(Arrays.asList(line.split("\\s")));
            // Collections.addAll(lines, line.split("\\s"));
        }

        // ใช้เช็คตัวที่เป็น operater ( ) semicolon keywords integer identifier
        // ตามโจทย์อาจารย์ เช็ค error ถ้าไม่ตรงโจทย์
        for (int i = 0; i < lines.size(); i++) {

            // ถ้าค่าที่ตรวจมีค่าเท่ากับ + - * / = > >= < <= == ++ -- ให้แสดงผลค่า operator
            // : ค่าที่ตรวจ
            if (lines.get(i).equals("+") || lines.get(i).equals("-") || lines.get(i).equals("*")
                    || lines.get(i).equals("/") || lines.get(i).equals("=") || lines.get(i).equals(">")
                    || lines.get(i).equals(">=") || lines.get(i).equals("<") || lines.get(i).equals("<=")
                    || lines.get(i).equals("==") || lines.get(i).equals("++") || lines.get(i).equals("--") ) {
                System.out.println("operator : " + lines.get(i));
                // ถ้าค่าที่ตรวจมีค่าเท่ากับ ( ) ให้แสดงผลค่า bracket : ค่าที่ตรวจ
            } else if (lines.get(i).equals("(") || lines.get(i).equals(")") || lines.get(i).equals("()")) {
                System.out.println("bracket : " + lines.get(i));
                // ถ้าค่าที่ตรวจมีค่าเท่ากับ ; ให้แสดงผลค่า semicolon : ค่าที่ตรวจ
            } else if (lines.get(i).equals(";")) {
                System.out.println("semicolon : " + lines.get(i));
                // ถ้าค่าที่ตรวจมีค่าเท่ากับ if then else endif while do endwhile print newline
                // read ให้แสดงผลค่า keywords : ค่าที่ตรวจ
            } else if (lines.get(i).equals("if") || lines.get(i).equals("then") || lines.get(i).equals("else")
                    || lines.get(i).equals("endif")
                    || lines.get(i).equals("while") || lines.get(i).equals("do")
                    || lines.get(i).equals("endwhile")
                    || lines.get(i).equals("print") || lines.get(i).equals("newline")
                    || lines.get(i).equals("read")) {
                System.out.println("keywords : " + lines.get(i));
                // ถ้าค่าที่ตรวจมีค่าเท่ากับ ตัวเลข integer 0-9 ให้แสดงผลค่า integers :
                // ค่าที่ตรวจ
            } else if (Pattern.matches("[0-9]*", lines.get(i))) {
                System.out.println("integers : " + lines.get(i));
                // ถ้าค่าที่ตรวจมีค่าเท่ากับ ตัวอักษรหรือตัวเลข 0-9 หรือแบบผสมทั้งคู่
                // ให้แสดงผลค่า new identifier : ค่าที่ตรวจ
            } else if (Pattern.matches("\\b[_a-zA-Z][_a-zA-Z0-9]*\\b", lines.get(i))) {// ^([a-zA-Z_$][a-zA-Z\\d_$]*)$
                // สร้างตัวแปร boolean ไปใช้ในเงื่อนไข
                boolean exist = true;
                // loop เพื่อเช็คว่าค่าที่ตรวจสอบมีค่าที่ตรงกันในอาเรย์ลิสต์ไหม ถ้ามี exist
                // จะเป็นค่า false
                for (int p = 0; p < identifier.size() - 1; p++) {
                    if (lines.get(i).equals(identifier.get(p))) {
                        exist = false;
                    }
                }

                // เช็คเงื่อนไขของ exist ถ้าเป็นจริงหมายความว่าค่าที่ตรวจสอบปัจจุบันไม่ซ้ำใครเลย
                // ค่านั้นจะถูกบันทึกลงอาเรย์ลิสต์
                if (exist) {
                    System.out.println("new identifier : " + lines.get(i));
                    identifier.add(lines.get(i));
                    // exist ถ้าเป็นเท็จหมายความว่าค่าที่ตรวจสอบปัจจุบันมีค่าที่ซ้ำกันในอาเรย์เลย
                    // ค่านั้นจะไม่ถูกบันทึกลงอาเรย์ลิสต์
                } else {
                    System.out.println("identifier " + lines.get(i) + " already exist in table");
                }
            } else {
                // จะเป็น error เมื่อมีค่าที่มีตัวเลขนำหน้าตัวอักษร
                System.out.println("error : " + lines.get(i));
                break;
            }

        }
    }
}
