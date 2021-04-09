package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        try {
            Functions functions = new Functions();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the file you want to work with in the format .txt");
            String fileName = sc.nextLine();
            functions.nameCheck(fileName);
            File fileData = new File(fileName);
            Scanner scanner = new Scanner(fileData);
            ArrayList<String> rows = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String row ;
                while (scanner.hasNextLine()) {
                    row = scanner.nextLine();
                    rows.add(row);
                }
            }
            functions.IsEmptyFile(rows);
            functions.removeEmptyLines(rows);
            System.out.println("Information in fail:");
            for(String c: rows){
                System.out.println(c);
            }
            while (true){
                System.out.println("Menu:\nSwap line - press 1\nSwap elements - press 2\nExit - press 0");
                int choice = sc.nextInt();
                if (choice == 1) {
                    functions.swapRows(rows, fileData);
                }
                else if(choice== 2){
                    functions.swapElement(rows, fileData);
                }
                else if(choice == 0){
                    System.out.println("Goodbye! Have a nice day");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid option entered");
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (WrongNameException wrongNameException){
            wrongNameException.printStackTrace();
        }catch (NoDataException noDataException){
            noDataException.printStackTrace();
        }


    }
}
