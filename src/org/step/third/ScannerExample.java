package org.step.third;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {

    /*
    Transient и static поля не сериализуются
     */
    private static String name;
    private transient String nameTransient;

    public static void main(String[] args) throws IOException {
        FileCheckerUtil.fileChecker();

        ScannerExample scannerExample = new ScannerExample();
//        scannerExample.fileReaderScanner();
        scannerExample.scannerFindLine();
        scannerExample.scannerWithSourceString();
    }

    public void fileReaderScanner() throws IOException {
        FileReader fr = new FileReader(FileCheckerUtil.MATERIAL_FILE);
        // new File("material.txt")
        Scanner scan = new Scanner(fr);

        while (scan.hasNext()) {
            if (scan.hasNextInt())
                System.out.println(scan.nextInt() + ":int");
            else if (scan.hasNextDouble())
                System.out.println(scan.nextDouble() + ":double");
            else if (scan.hasNextBoolean())
                System.out.println(scan.nextBoolean() + ":boolean");
            else
                System.out.println(scan.next() + ":String");
        }
        fr.close();
    }

    public void scannerWithSourceString() {
        Scanner scan = new Scanner("1,3;2,0; 8,5; 4,8; 9,0; 1; 10");

        double sum = 0.0;

        scan.useDelimiter(";\\s*");

        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                sum += scan.nextDouble();
            } else {
                System.out.println(scan.next());
            }
        }
        System.out.printf("Сумма чисел = %f", sum);
    }

    public void scannerFindLine() {
        String instr = "Name: Joe Age: 28 ID: 77";
        Scanner ageFinder = new Scanner(instr);

        ageFinder.findInLine("Age:"); // find Age

        if (ageFinder.hasNext())
            System.out.println(ageFinder.next());
        else
            System.out.println("Error!");
    }
}
