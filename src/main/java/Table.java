import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Table {
    public Set<String> VALID_DIRECTIONS = new HashSet<>(Arrays.asList("NORTH", "SOUTH", "EAST", "WEST"));
    public Set<String> VALID_COMMANDS = new HashSet<>(Arrays.asList("PLACE", "MOVE", "LEFT", "RIGHT", "REPORT"));

    private int rows;
    private int columns;
    private Robot robot;

    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void placeRobot(int x, int y, String direction) {
        if(isValidDirection(direction) && isWithinTable(x, y)) {
            this.robot = new Robot(x, y, direction);
        }
    }

    public void action(String command) {
        if(isRobotPlaced() && isValidCommand(command)) {
            switch(command) {
                case "MOVE" : moveRobot(); break;
                case "LEFT" :
                case "RIGHT" : this.robot.changeDirection(command); break;
                case "REPORT" : System.out.println("Output: " + robot); break;
            }
        }
    }

    private boolean isRobotPlaced() {
        return this.robot != null;
    }

    private boolean isValidCommand(String command) {
        return VALID_COMMANDS.contains(command);
    }

    private boolean isValidDirection(String direction) {
        return VALID_DIRECTIONS.contains(direction);
    }

    private boolean isWithinTable(int x, int y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < columns);
    }

    private void moveRobot() {
        switch (this.robot.getDirection()) {
            case "NORTH":
                if(isWithinTable(this.robot.getX(), this.robot.getY()+1))
                    this.robot.move(this.robot.getX(), this.robot.getY()+1);
                break;
            case "SOUTH":
                if(isWithinTable(this.robot.getX(), this.robot.getY()-1))
                    this.robot.move(this.robot.getX(), this.robot.getY()-1);
                break;
            case "EAST":
                if(isWithinTable(this.robot.getX()+1, this.robot.getY()))
                    this.robot.move(this.robot.getX()+1, this.robot.getY());
                break;
            case "WEST":
                if(isWithinTable(this.robot.getX()-1, this.robot.getY()))
                    this.robot.move(this.robot.getX()-1, this.robot.getY());
                break;
        }
    }
}
