package flower.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<FlowerBucket> flowerBuckets;

    public Store() {
        flowerBuckets = new ArrayList<>();
    }

    public void add(FlowerBucket flowerBucket) {
        flowerBuckets.add(flowerBucket);
    }

    public List<FlowerBucket> search(List<FlowerType> types) {
        List<FlowerBucket> suitableBuckets = new ArrayList<>();
        for (FlowerBucket suitableBucket : this.flowerBuckets) {
            List<FlowerType> currentTypes = suitableBucket.getAllFlowerTypes();
            if (currentTypes.containsAll(types)) {
                suitableBuckets.add(suitableBucket);
            }
        }
        return suitableBuckets;
    }
}
