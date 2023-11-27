import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challenge1Ans = challengeOne("inputOneTwo.txt");
        System.out.println(challenge1Ans);
        int challenge2Ans = challengeTwo("inputOneTwo.txt");
        System.out.println(challenge2Ans);
        int challenge3Ans = challengeThree("inputThreeFour.txt");
        System.out.println(challenge3Ans);
        int challenge4Ans = challengeFour("inputThreeFour.txt");
        System.out.println(challenge4Ans);

        writeFileAllAnswers("AdventureTime.txt", challenge1Ans, challenge2Ans, challenge3Ans, challenge4Ans);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] array = readFile(fileName);
        int count = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) count++;
        }

        return count;    // ans = 1655
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] array = readFile(fileName);
        int[] sums = new int[array.length-2];
        int count = 0;
        int j = 0;

        for (int i = 0; i < array.length-2; i++) {
            sums[j] = array[i] + array[i+1] + array[i+2];
            j++;
        }

        for (int i = 0; i < sums.length-1; i++) if (sums[i+1] > sums[i]) count++;

        return count;    // ans = 1683
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String array[] = readFile2(fileName);
        int x = 0;     // horizontal position
        int y = 0;     // depth

        for (String temp : array) {
            int value = Integer.parseInt(temp.substring(temp.length() - 1));
            if (temp.contains("forward")) x += value;
            else if (temp.contains("up")) y -= value;
            else if (temp.contains("down")) y += value;
        }

        return x * y;   // ans = 1524750
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String array[] = readFile2(filename);
        int x = 0;     // horizontal position
        int y = 0;     // depth
        int aim = 0;

        for (String temp : array) {
            int value = Integer.parseInt(temp.substring(temp.length() - 1));
            if (temp.contains("forward")) {
                x += value;
                y += aim * value;
            }
            if (temp.contains("up")) {
                aim -= value;
            }
            if (temp.contains("down")) {
                aim += value;
            }
        }

        return x * y;     // ans = 1592426537
    }


    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}