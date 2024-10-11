package flower.store;

public class Tulip extends Flower {

    public Tulip(Flower tulip) {
        super(tulip);
        this.setType(FlowerType.TULIP);
    }

    public Tulip() {
        super();
        this.setType(FlowerType.TULIP);
    }

}


