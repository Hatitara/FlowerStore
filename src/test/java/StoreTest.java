import flower.store.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreTest {
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
        FlowerBucket flowerBucket1 = new FlowerBucket();
        FlowerBucket flowerBucket2 = new FlowerBucket();

        flowerBucket1.add(new FlowerPack(new Rose(), 5));
        flowerBucket2.add(new FlowerPack(new Tulip(), 10));

        store.add(flowerBucket1);
        store.add(flowerBucket2);

        List<FlowerType> typesToSearch = Arrays.asList(FlowerType.ROSE);
        List<FlowerBucket> searchResult = store.search(typesToSearch);

        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.contains(flowerBucket1));
        Assertions.assertFalse(searchResult.contains(flowerBucket2));

        typesToSearch = Arrays.asList(FlowerType.TULIP);
        searchResult = store.search(typesToSearch);
        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.contains(flowerBucket2));
        Assertions.assertFalse(searchResult.contains(flowerBucket1));
    }

    @Test
    public void testSearchWithMultipleTypes() {
        FlowerBucket flowerBucket1 = new FlowerBucket();
        FlowerBucket flowerBucket2 = new FlowerBucket();

        flowerBucket1.add(new FlowerPack(new Rose(), 5));
        flowerBucket1.add(new FlowerPack(new Tulip(), 10));
        flowerBucket2.add(new FlowerPack(new Rose(), 3));

        store.add(flowerBucket1);
        store.add(flowerBucket2);

        List<FlowerType> typesToSearch = Arrays.asList(FlowerType.ROSE,
                FlowerType.TULIP);
        List<FlowerBucket> searchResult = store.search(typesToSearch);
        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.contains(flowerBucket1));
        Assertions.assertFalse(searchResult.contains(flowerBucket2));
    }
}
