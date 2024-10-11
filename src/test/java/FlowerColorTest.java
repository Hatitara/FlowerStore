import flower.store.FlowerColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowerColorTest {

    @Test
    public void testFlowerColorValues() {
        Assertions.assertEquals("#FF0000",
                FlowerColor.RED.getCode());
        Assertions.assertEquals("#FFFFFF",
                FlowerColor.WHITE.getCode());
        Assertions.assertEquals("#FFFF00",
                FlowerColor.YELLOW.getCode());
    }

    @Test
    public void testFlowerColorEnumValues() {
        FlowerColor[] expectedValues = {
                FlowerColor.RED, FlowerColor.WHITE, FlowerColor.YELLOW
        };
        Assertions.assertArrayEquals(expectedValues, FlowerColor.values());
    }

    @Test
    public void testFlowerColorValueOf() {
        Assertions.assertEquals(FlowerColor.RED,
                FlowerColor.valueOf("RED"));
        Assertions.assertEquals(FlowerColor.WHITE,
                FlowerColor.valueOf("WHITE"));
        Assertions.assertEquals(FlowerColor.YELLOW,
                FlowerColor.valueOf("YELLOW"));
    }
}
