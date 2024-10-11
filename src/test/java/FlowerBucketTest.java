import flower.store.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

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
        flower.setPrice(10);
        FlowerPack flowerPack = new FlowerPack(flower, 5);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(50, flowerBucket.getPrice());
    }

    @Test
    public void testGetAllFlowerTypes() {
        Flower rose = new Rose();
        rose.setPrice(15);
        FlowerPack rosePack = new FlowerPack(rose, 3);
        Flower chamomile = new Flower();
        chamomile.setPrice(7);
        chamomile.setType(FlowerType.CHAMOMILE);
        FlowerPack chamomilePack = new FlowerPack(chamomile, 4);
        flowerBucket.add(rosePack);
        flowerBucket.add(chamomilePack);
        List<FlowerType> flowerTypes = flowerBucket.getAllFlowerTypes();
        Assertions.assertEquals(2, flowerTypes.size());
        Assertions.assertTrue(flowerTypes.contains(FlowerType.ROSE));
        Assertions.assertTrue(flowerTypes.contains(FlowerType.CHAMOMILE));
    }
}
