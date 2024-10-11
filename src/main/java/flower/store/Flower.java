package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Flower {
    private FlowerColor color;
    private FlowerType type;
    private double sepalLength;
    private double price;

    public String getColor() {
        return color.getCode();
    }

    public Flower (Flower flower) {
        this.color = flower.color;
        this.type = flower.type;
        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
    }

}
