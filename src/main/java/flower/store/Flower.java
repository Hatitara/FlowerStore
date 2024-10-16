package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Flower {
    private FlowerColor color;
    private FlowerType type;
    private double sepalLength;
    private double price;

    public Flower(Flower flower) {
        this.color = flower.color;
        this.type = flower.type;
        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
    }

    public String getColor() {
        return color.getCode();
    }
}
