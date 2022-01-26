import org.junit.Assert;
import org.junit.Test;

public class ToyTest {

    @Test
    public void testIgnoredCommand() {
        Table table = new Table(5, 5);
        table.action("MOVE");
        Assert.assertFalse(table.isRobotPlaced());
    }

    @Test
    public void testInvalidDirection() {
        Table table = new Table(5, 5);
        table.placeRobot(0,0, "SOUTHWEST");
        Assert.assertFalse(table.isRobotPlaced());
    }

    @Test
    public void testInvalidCommand() {
        Table table = new Table(5, 5);
        table.action("CHARGE");
        Assert.assertFalse(table.isRobotPlaced());
    }

    @Test
    public void testValidPlacementOfRobot() {
        Table table = new Table(5, 5);
        table.placeRobot(0,0, "NORTH");
        Assert.assertTrue(table.isRobotPlaced());
        Assert.assertEquals("0,0,NORTH", table.getRobot().toString());
    }

    @Test
    public void testInvalidPlacementOfRobot() {
        Table table = new Table(5, 5);
        table.placeRobot(5,5, "NORTH");
        Assert.assertFalse(table.isRobotPlaced());
    }

    @Test
    public void testValidPlacementAndMovement() {
        Table table = new Table(5, 5);
        table.placeRobot(1,2, "EAST");
        table.action("MOVE");
        table.action("MOVE");
        table.action("LEFT");
        table.action("MOVE");
        table.action("REPORT");
        Assert.assertTrue(table.isRobotPlaced());
        Assert.assertEquals("3,3,NORTH", table.getRobot().toString());
    }
}
