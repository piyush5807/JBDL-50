import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        p1.Main main = new p1.Main();

        switch (input){
            case 1: System.out.println(main.add(a, b));
                break;
            case 2: System.out.println(main.subtract(a, b));
                break;
            case 3: System.out.println(main.multiply(a, b));
                break;
            case 4: System.out.println(main.divide(a, b));
                break;
            case 5: System.out.println(main.power(a, b));
                break;
            default:
                throw new Exception("Invalid input found");
        }
    }
}
