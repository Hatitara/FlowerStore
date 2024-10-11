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
    private static final int PRICE1 = 10;
    private static final int AMOUNT1 = 5;
    private static final int EXPECTED1 = 50;
    private static final int PRICE2 = 15;
    private static final int AMOUNT2 = 3;
    private static final int PRICE3 = 7;
    private static final int AMOUNT3 = 4;
    private static final int EXPECTED2 = 2;

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
        flower.setPrice(PRICE1);
        FlowerPack flowerPack = new FlowerPack(flower, AMOUNT1);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(EXPECTED1, flowerBucket.getPrice());
    }

    @Test
    public void testGetAllFlowerTypes() {
        Flower rose = new Rose();
        rose.setPrice(PRICE2);
        FlowerPack rosePack = new FlowerPack(rose, AMOUNT2);
        Flower chamomile = new Flower();
        chamomile.setPrice(PRICE3);
        chamomile.setType(FlowerType.CHAMOMILE);
        FlowerPack chamomilePack = new FlowerPack(chamomile, AMOUNT3);
        flowerBucket.add(rosePack);
        flowerBucket.add(chamomilePack);
        List<FlowerType> flowerTypes = flowerBucket.getAllFlowerTypes();
        Assertions.assertEquals(EXPECTED2, flowerTypes.size());
        Assertions.assertTrue(flowerTypes.contains(FlowerType.ROSE));
        Assertions.assertTrue(flowerTypes.contains(FlowerType.CHAMOMILE));
    }
}
