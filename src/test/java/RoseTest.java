import flower.store.FlowerColor;
import flower.store.Rose;
import flower.store.FlowerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoseTest {
    private Rose rose;

    @BeforeEach
    public void init() {
        rose = new Rose();
    }

    @Test
    public void testDefaultConstructor() {
        Assertions.assertEquals(FlowerType.ROSE, rose.getType());
    }

    @Test
    public void testConstructorWithParams() {
        rose.setPrice(10.0);
        rose.setColor(FlowerColor.RED);
        Assertions.assertEquals(10.0, rose.getPrice());
        Assertions.assertEquals(FlowerColor.RED.getCode(), rose.getColor());
    }

    @Test
    public void testCopyConstructor() {
        Rose anotherRose = new Rose(rose);
        Assertions.assertEquals(rose.getType(), anotherRose.getType());
        Assertions.assertEquals(rose.getPrice(), anotherRose.getPrice());
    }

}
