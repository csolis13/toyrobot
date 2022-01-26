public class Robot {

    private String direction = null;
    private int x = -1;
    private int y = -1;

    public Robot(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeDirection(String command) {
        switch(direction) {
            case "NORTH":
                if("LEFT".equals(command))
                    this.direction = "WEST";
                else
                    this.direction = "EAST";
                break;
            case "SOUTH":
                if("LEFT".equals(command))
                    this.direction = "EAST";
                else
                    this.direction = "WEST";
                break;
            case "EAST":
                if("LEFT".equals(command))
                    this.direction = "NORTH";
                else
                    this.direction = "SOUTH";
                break;
            case "WEST":
                if("LEFT".equals(command))
                    this.direction = "SOUTH";
                else
                    this.direction = "NORTH";
                break;
        }
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return this.getX() + "," + this.getY() + "," + this.getDirection();
    }
}
