import flower.store.Flower;
import flower.store.FlowerBucket;
import flower.store.FlowerPack;
import flower.store.Rose;
import flower.store.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;
    private static final int PRICE_ONE = 10;
    private static final int AMOUNT_ONE = 5;
    private static final int EXPECTED_ONE = 50;
    private static final int PRICE_TWO = 15;
    private static final int AMOUNT_TWO = 3;
    private static final int PRICE_THREE = 7;
    private static final int AMOUNT_THREE = 4;
    private static final int EXPECTED_TWO = 2;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testAddFlowerPack() {
        Flower flower = new Rose();
        flower.setPrice(PRICE_ONE);
        FlowerPack flowerPack = new FlowerPack(flower, AMOUNT_ONE);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(EXPECTED_ONE, flowerBucket.getPrice());
    }

    @Test
    public void testGetAllFlowerTypes() {
        Flower rose = new Rose();
        rose.setPrice(PRICE_TWO);
        FlowerPack rosePack = new FlowerPack(rose, AMOUNT_TWO);
        Flower chamomile = new Flower();
        chamomile.setPrice(PRICE_THREE);
        chamomile.setType(FlowerType.CHAMOMILE);
        FlowerPack chamomilePack = new FlowerPack(chamomile, AMOUNT_THREE);
        flowerBucket.add(rosePack);
        flowerBucket.add(chamomilePack);
        List<FlowerType> flowerTypes = flowerBucket.getAllFlowerTypes();
        Assertions.assertEquals(EXPECTED_TWO, flowerTypes.size());
        Assertions.assertTrue(flowerTypes.contains(FlowerType.ROSE));
        Assertions.assertTrue(flowerTypes.contains(FlowerType.CHAMOMILE));
    }
}
