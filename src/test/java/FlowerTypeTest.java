import flower.store.FlowerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowerTypeTest {
    private static final int EXPECTED = 3;

    @Test
    public void testEnumValues() {
        FlowerType[] types = FlowerType.values();
        Assertions.assertEquals(EXPECTED, types.length);
        Assertions.assertTrue(FlowerType.ROSE instanceof FlowerType);
        Assertions.assertTrue(FlowerType.TULIP instanceof FlowerType);
        Assertions.assertTrue(FlowerType.CHAMOMILE instanceof FlowerType);
    }

    @Test
    public void testEnumNames() {
        Assertions.assertEquals("ROSE", FlowerType.ROSE.name());
        Assertions.assertEquals("TULIP", FlowerType.TULIP.name());
        Assertions.assertEquals("CHAMOMILE", FlowerType.CHAMOMILE.name());
    }
}
