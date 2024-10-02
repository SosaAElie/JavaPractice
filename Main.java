import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Classes.TextToNumber;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        //Answer to AdventofCode 2023 Day 1 Part 1 & 2
        File inputFile = new File("input.txt");
        ArrayList<Byte> firstLast = new ArrayList<Byte>();
        int sum = 0;
        try(Scanner scanner = new Scanner(inputFile);){
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                ArrayList<Byte> numbers = getAllNumbers(currentLine, true);
                // System.out.println(currentLine + " "+ numbers.toString());
                byte first = (byte) (numbers.get(0) * 10);
                byte last = (byte) (numbers.get(numbers.size()-1));
                byte number = (byte) (first + last);
                firstLast.add(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(byte num : firstLast){
            sum+=num;
        }
        System.out.println(sum);
    }

    public static ArrayList<Byte> getAllNumbers(String line, boolean partTwo){
        //Parses through the string and attempts to convert each character into a number of byte size
        //Returns a reference to the list of numbers found
        ArrayList<Byte> numbers = new ArrayList<Byte>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.length(); i++){
            char currentChar = line.charAt(i);
            try{
                byte currentNum = Byte.parseByte(String.valueOf(currentChar));
                numbers.add(currentNum);
                sb.delete(0, sb.length());
            }catch(NumberFormatException e){
                if(partTwo){
                    sb.append(currentChar);
                    byte textNum = TextToNumber.toNumber(sb.toString());
                    if(textNum > -1){
                        numbers.add(textNum);
                        //To account for the edge case when the 'e' of 'eight' is within 'one'
                        //Don't delete the last letter
                        sb.delete(0, sb.length()-1);
                    }
                    else{
                        continue;
                    }
                }
                else{
                    continue;
                }
            }
        }
        return numbers;
    }
}