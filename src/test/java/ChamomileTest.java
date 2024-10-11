import flower.store.Chamomile;
import flower.store.Flower;
import flower.store.FlowerColor;
import flower.store.FlowerType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ChamomileTest {
    Double TEST = 5.0;

    @Test
    public void testDefaultConstructor() {
        Chamomile chamomile = new Chamomile();
        Assertions.assertEquals(FlowerType.CHAMOMILE, chamomile.getType());
    }

    @Test
    public void testCopyConstructor() {
        Flower originalFlower = new Flower();
        originalFlower.setColor(FlowerColor.WHITE);
        originalFlower.setPrice(TEST);
        originalFlower.setType(FlowerType.CHAMOMILE);
        Chamomile chamomile = new Chamomile(originalFlower);
        Assertions.assertEquals(FlowerType.CHAMOMILE, chamomile.getType());
        Assertions.assertEquals(FlowerColor.WHITE.getCode(), chamomile.getColor());
        Assertions.assertEquals(TEST, chamomile.getPrice());
    }

    @Test
    public void testSetType() {
        Chamomile chamomile = new Chamomile();
        chamomile.setType(FlowerType.ROSE);
        Assertions.assertEquals(FlowerType.ROSE, chamomile.getType());
    }
}
