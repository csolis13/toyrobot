import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Table table = new Table(5, 5);

        Scanner sc= new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if(input.split(" ").length == 2) {
                String command = input.split(" ")[0];
                if("PLACE".equals(command)) {
                    String[] placeArgs = input.split(" ")[1].split(",");
                    if(placeArgs.length == 3) {
                        try {
                            int x = Integer.parseInt(placeArgs[0]);
                            int y = Integer.parseInt(placeArgs[1]);
                            String direction = placeArgs[2];
                            table.placeRobot(x, y, direction);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }
            } else {
                table.action(input);
            }
        }
    }
}
