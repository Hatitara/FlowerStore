import flower.store.Flower;
import flower.store.FlowerPack;
import flower.store.Rose;
import flower.store.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowerPackTest {

    private static final double PRICE_PER_FLOWER = 5.0;
    private static final int QUANTITY = 10;
    private static final int NUMBER1 = 15;
    private static final int NUMBER2 = 8;
    private Flower flower;
    private FlowerPack flowerPack;

    @BeforeEach
    public void setUp() {
        flower = new Rose();
        flower.setPrice(PRICE_PER_FLOWER);
        flowerPack = new FlowerPack(flower, QUANTITY);
    }

    @Test
    public void testGetPrice() {
        double expectedPrice = PRICE_PER_FLOWER * QUANTITY;
        Assertions.assertEquals(expectedPrice, flowerPack.getPrice());
    }

    @Test
    public void testGetPackFlowerType() {
        Assertions.assertEquals(FlowerType.ROSE,
                flowerPack.getPackFlowerType());
    }

    @Test
    public void testConstructorAndSetters() {
        Assertions.assertEquals(flower, flowerPack.getFlower());
        Assertions.assertEquals(QUANTITY, flowerPack.getCount());
        Flower newFlower = new Rose();
        newFlower.setPrice(NUMBER2);
        flowerPack.setFlower(newFlower);
        flowerPack.setCount(NUMBER1);
        Assertions.assertEquals(newFlower, flowerPack.getFlower());
        Assertions.assertEquals(NUMBER1, flowerPack.getCount());
    }
}
