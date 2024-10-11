import flower.store.FlowerColor;
import flower.store.FlowerType;
import flower.store.Tulip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TulipTest {
    private static final int TEN = 10;
    private static final int NUMBER = 15;
    private Tulip tulip;

    @BeforeEach
    public void init() {
        tulip = new Tulip();
    }

    @Test
    public void testDefaultConstructor() {
        Assertions.assertEquals(FlowerType.TULIP, tulip.getType());
    }

    @Test
    public void testCopyConstructor() {
        tulip.setPrice(TEN);
        tulip.setColor(FlowerColor.RED);

        Tulip tulipCopy = new Tulip(tulip);
        Assertions.assertEquals(tulip.getPrice(), tulipCopy.getPrice());
        Assertions.assertEquals(tulip.getColor(), tulipCopy.getColor());
        Assertions.assertEquals(tulip.getType(), tulipCopy.getType());
    }

    @Test
    public void testSetColor() {
        tulip.setColor(FlowerColor.YELLOW);
        Assertions.assertEquals(FlowerColor.YELLOW.getCode(), tulip.getColor());
    }

    @Test
    public void testSetPrice() {
        tulip.setPrice(NUMBER);
        Assertions.assertEquals(NUMBER, tulip.getPrice());
    }
}
