import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Task {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to my cellWorld! \n Change the mode of work \n" +
                "1. AutoGeneration \n" +
                "2. Read from file \n" +
                "Type your choice: ");
        byte input = Byte.parseByte(br.readLine());
        if (input == 1) {
            System.out.println("input High of field: ");
            int x = Integer.parseInt(br.readLine());
            System.out.println("input size: ");
            int y = Integer.parseInt(br.readLine());
            Field field = new Field(x, y);
            Timer(field);

        }
        else if(input == 2){
            System.out.println("input path to the file: ");
            File file = new File(br.readLine());
            FReader fr = new FReader();
            fr.Reader(file);
            Field field = new Field(fr.y, fr.x, fr.field);
            Timer(field);

        }


    }
    private static void Timer (Field field) {
        try {
            field.show();
            field.fieldReview();
            Thread.sleep(1000);
            Timer(field);
        }
        catch (Exception e){

        }
    }

}

