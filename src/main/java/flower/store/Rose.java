package flower.store;

public class Rose extends Flower {
    public Rose(Flower rose) {
        super(rose);
        this.setType(FlowerType.ROSE);
    }

    public Rose() {
        super();
        this.setType(FlowerType.ROSE);
    }

}
