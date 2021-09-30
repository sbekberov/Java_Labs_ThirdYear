package Lab1;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
        public static void main(String[] args) {
            String[] words = {"AAAAA", "BBBBBB", "CCCCCCC", "DDDD", "KJKJKJKJKJKJKJK"};
            boolean isWork = true;
            while (isWork) {
                System.out.println("Выберите действие: " +
                        "\n\t1)Вывести слова меньше среднего" +
                        "\n\t2)Вывести слова больше среднего");
                Scanner in = new Scanner(System.in);
                try {
                    int userInput = in.nextInt();
                    in.close();

                    switch (userInput) {
                        case 1:
                            for (var word : getLessThanAverage(words)) {
                                System.out.println(word);
                            }
                            isWork = false;
                            break;
                        case 2:
                            for (var word : getMoreThanAverage(words)) {
                                System.out.println(word);
                            }
                            isWork = false;
                            break;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Введите число!");
                    isWork = false;
                }

            }
        }
        public static int findAverage(String[] words){
            int average = 0;
            for (var word:
                    words) {
                average += word.length();
            }
            return average/words.length;
        }
        public static ArrayList<String> getLessThanAverage(String[] words){
            int average = findAverage(words);
            ArrayList<String> wordLessAverage = new ArrayList<>();
            for (var word:words) {
                if (word.length() < average){
                    wordLessAverage.add(word);
                }
            }

            return wordLessAverage;
        }
        public static ArrayList<String> getMoreThanAverage(String[] words){
            int average = findAverage(words);
            ArrayList<String> wordMoreAverage = new ArrayList<>();
            for (var word:words) {
                if (word.length() > average){
                    wordMoreAverage.add(word);
                }
            }
            return wordMoreAverage;
        }
    }

