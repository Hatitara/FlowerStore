import flower.store.FlowerColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowerColorTest {

    @Test
    public void testFlowerColorValues() {
        // Verify the color code for each FlowerColor constant
        Assertions.assertEquals("#FF0000", FlowerColor.RED.getCode(), "Incorrect color code for RED");
        Assertions.assertEquals("#FFFFFF", FlowerColor.WHITE.getCode(), "Incorrect color code for WHITE");
        Assertions.assertEquals("#FFFF00", FlowerColor.YELLOW.getCode(), "Incorrect color code for YELLOW");
    }

    @Test
    public void testFlowerColorEnumValues() {
        // Verify the enum contains the correct constants
        FlowerColor[] expectedValues = { FlowerColor.RED, FlowerColor.WHITE, FlowerColor.YELLOW };
        Assertions.assertArrayEquals(expectedValues, FlowerColor.values(), "Enum constants do not match expected values");
    }

    @Test
    public void testFlowerColorValueOf() {
        // Verify that valueOf method returns the correct enum constant
        Assertions.assertEquals(FlowerColor.RED, FlowerColor.valueOf("RED"), "valueOf did not return RED as expected");
        Assertions.assertEquals(FlowerColor.WHITE, FlowerColor.valueOf("WHITE"), "valueOf did not return WHITE as expected");
        Assertions.assertEquals(FlowerColor.YELLOW, FlowerColor.valueOf("YELLOW"), "valueOf did not return YELLOW as expected");
    }
}
