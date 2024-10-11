import flower.store.Store;
import flower.store.FlowerPack;
import flower.store.FlowerBucket;
import flower.store.Rose;
import flower.store.Tulip;
import flower.store.FlowerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreTest {
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    public void testAdd() {
        FlowerBucket flowerBucket = new FlowerBucket();
        store.add(flowerBucket);

        Assertions.assertEquals(1, store.search(new ArrayList<>()).size());
    }

    @Test
    public void testSearch() {
        FlowerBucket flowerBucketOne = new FlowerBucket();
        FlowerBucket flowerBucketTwo = new FlowerBucket();

        flowerBucketOne.add(new FlowerPack(new Rose(), FIVE));
        flowerBucketTwo.add(new FlowerPack(new Tulip(), TEN));

        store.add(flowerBucketOne);
        store.add(flowerBucketTwo);

        List<FlowerType> typesToSearch = Arrays.asList(FlowerType.ROSE);
        List<FlowerBucket> searchResult = store.search(typesToSearch);

        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.contains(flowerBucketOne));
        Assertions.assertFalse(searchResult.contains(flowerBucketTwo));

        typesToSearch = Arrays.asList(FlowerType.TULIP);
        searchResult = store.search(typesToSearch);
        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.contains(flowerBucketTwo));
        Assertions.assertFalse(searchResult.contains(flowerBucketOne));
    }

    @Test
    public void testSearchWithMultipleTypes() {
        FlowerBucket flowerBucketOne = new FlowerBucket();
        FlowerBucket flowerBucketTwo = new FlowerBucket();

        flowerBucketOne.add(new FlowerPack(new Rose(), FIVE));
        flowerBucketOne.add(new FlowerPack(new Tulip(), TEN));
        flowerBucketTwo.add(new FlowerPack(new Rose(), THREE));

        store.add(flowerBucketOne);
        store.add(flowerBucketTwo);

        List<FlowerType> typesToSearch = Arrays.asList(FlowerType.ROSE,
                FlowerType.TULIP);
        List<FlowerBucket> searchResult = store.search(typesToSearch);
        Assertions.assertEquals(ONE, searchResult.size());
        Assertions.assertTrue(searchResult.contains(flowerBucketOne));
        Assertions.assertFalse(searchResult.contains(flowerBucketTwo));
    }
}
