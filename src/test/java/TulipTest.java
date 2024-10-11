import flower.store.FlowerColor;
import flower.store.FlowerType;
import flower.store.Tulip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TulipTest {
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
        tulip.setPrice(10);
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
        tulip.setPrice(15);
        Assertions.assertEquals(15, tulip.getPrice());
    }
}
