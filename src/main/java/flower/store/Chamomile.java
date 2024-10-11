package flower.store;

public class Chamomile extends Flower{
    public Chamomile(Flower chamomile) {
        super(chamomile);
        this.setType(FlowerType.CHAMOMILE);
    }

    public Chamomile() {
        super();
        this.setType(FlowerType.CHAMOMILE);
    }

}
