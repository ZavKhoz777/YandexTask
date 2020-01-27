import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to my cellWorld! \n Change the mode of work \n" +
                "1. AutoGeneration \n" +
                "2. Read from file \n" +
                "Type your choice: ");

        if (Integer.parseInt(br.readLine()) == 1) {
            System.out.println("input High of field: ");
            int x = Integer.parseInt(br.readLine());
            System.out.println("input size: ");
            int y = Integer.parseInt(br.readLine());
            Field field = new Field(x, y);
            field.show();
            System.out.println();
            for (int i = 0; i < 1; i++) {
                field.fieldReview();
                field.show();
            }
        }


    }

}

