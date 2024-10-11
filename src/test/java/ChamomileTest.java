import flower.store.Chamomile;
import flower.store.Flower;
import flower.store.FlowerColor;
import flower.store.FlowerType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChamomileTest {

    @Test
    public void testDefaultConstructor() {
        Chamomile chamomile = new Chamomile();
        assertEquals(FlowerType.CHAMOMILE, chamomile.getType());
    }

    @Test
    public void testCopyConstructor() {
        Flower originalFlower = new Flower();
        originalFlower.setColor(FlowerColor.WHITE);
        originalFlower.setPrice(5.0);
        originalFlower.setType(FlowerType.CHAMOMILE);
        Chamomile chamomile = new Chamomile(originalFlower);
        assertEquals(FlowerType.CHAMOMILE, chamomile.getType());
        assertEquals("#FFFFFF", chamomile.getColor());
        assertEquals(5.0, chamomile.getPrice());
    }

    @Test
    public void testSetType() {
        Chamomile chamomile = new Chamomile();
        chamomile.setType(FlowerType.ROSE);
        assertEquals(FlowerType.ROSE, chamomile.getType());
    }
}
