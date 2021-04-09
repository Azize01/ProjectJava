package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Functions {
    public void swapRows(ArrayList<String> rows, File fileData) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first line number you want to exchange: ");
        int indexToSwapOne = scan.nextInt();
        System.out.println("Enter the second line number you want to exchange: ");
        int indexToSwapTwo = scan.nextInt();
        Collections.swap(rows, indexToSwapOne-1, indexToSwapTwo-1);
        System.out.println("New file looks like");
        FileWriter myWriter = new FileWriter(fileData);
        for(String c: rows){
            System.out.println(c);
            myWriter.write(c + System.lineSeparator());
        }
        myWriter.close();
        System.out.println("\nТhe data saved to the file successfully");
        System.out.println("\n");
    }

    public void swapElement(ArrayList<String> rows, File fileData) throws IOException {
        int i, j;
        Scanner scanner = new Scanner(System.in);
        String[][] array = new String[rows.size()][];
        for ( i = 0; i < rows.size(); i++) {
            String [] row = rows.get(i).split(" ");
            array[i] = row;
        }
        System.out.println("From which row you want to exchange an item? ");
        int i1 = scanner.nextInt();
        System.out.println("Which element in order? ");
        int j1 = scanner.nextInt();
        System.out.println("From which row you want to exchange an item? ");
        int i2 = scanner.nextInt();
        System.out.println("Which element in order? ");
        int j2 = scanner.nextInt();
        String element = array[i1-1][j1-1];
        array[i1-1][j1-1] = array[i2-1][j2-1];
        array[i2-1][j2-1] = element;

        System.out.println("New file looks like");
        FileWriter fileWriter = new FileWriter(fileData);
        for ( i = 0; i < array.length; i++){
            System.out.println();
            for (j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
                fileWriter.write(array[i][j] + " ");
            }
            fileWriter.write("\n");
        }

        fileWriter.close();
        System.out.println("\nТhe data saved to the file successfully");
        System.out.println("\n");
    }

    public void nameCheck(String fileName)throws WrongNameException {
        String end = fileName.substring(fileName.length()-4);
        if(!end.equals(".txt")){
            throw new WrongNameException("The document must end with .txt");
        }

    }
    public void removeEmptyLines(ArrayList<String> temps){
        for (int i=0; i< temps.size(); i++){
            if(temps.get(i).isEmpty()) {
                temps.remove(i);
            }
        }
    }
    public void IsEmptyFile(ArrayList<String> temps) throws NoDataException{
        if(temps.isEmpty()){
            throw new NoDataException("No data in file");
        }
    }


}


