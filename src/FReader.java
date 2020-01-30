import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FReader {
    static int y = 0;
    static int x = 0;
    static byte[][] field;
    static int count = 0;
    public static void Reader(File file) {
        try{
            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String buffer = scan.nextLine();
                Parser(buffer);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Wrong input. File not found.");
        }
    }
    private static void Parser(String line) {
        if (y == 0) {
            y = Integer.parseInt(line);
        }
        else if (x == 0) {
            x = Integer.parseInt(line);
            field = new byte[y][x];
        }
        else{
            String[] set = line.split(" ");
            if (set.length == x) {
                for (int i = 0; i < x; i++) {
                    field[count][i] = Byte.parseByte(set[i]);
                }
            }
            count++;
        }
    }

}
