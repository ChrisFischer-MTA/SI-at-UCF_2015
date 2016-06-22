package Cat;

import java.awt.Color;

public class Cat {

    private int weight;
    private Color furColor;
    private String name;
    private int height;
    private int tailLength;
    private String breed;
    private boolean declawed;

    public Cat() {
        weight = 0;
        furColor = Color.BLACK;
        name = "Caden";
        height = 2;
        tailLength = 0;
        breed = "Generic Cat Breed";
        declawed = false;
    }

    public Cat(String name) {
        weight = 0;
        furColor = Color.BLACK;
        height = 2;
        tailLength = 0;
        breed = "Generic Cat Breed";
        declawed = false;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getfurColor() {
        return furColor;
    }

    public void setfurColor(Color furColor) {
        this.furColor = furColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTaillength(int weight) {
        this.tailLength = tailLength;
    }

    public String breed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void meow() {
        System.out.println("Moew");
    }

    public void purr() {
        System.out.println("Purr");
    }

    public void walk() {
        System.out.println("*The tapping of the cats feet could be heard*");
    }

    public void sleep() {
        System.out.println("*Sleeping*");
    }

    public void eat(int foodWeight) {
        setWeight(getWeight() + foodWeight);
    }

    public boolean isFat() {
        if (this.weight > 15) {
            return true;
        }
        return false;
    }

    public boolean isFancy() {
        switch (breed) {
            case "Persian":
            case "Egyptian":
                return true;

            case "Tabby":
                return false;
            default:
                return false;
        }
    }

    public boolean isLazy() {
        return true;
    }

    public boolean isDoge() {
        return false;
    }

    public boolean isMeme() {
        return true;
    }

    public boolean canScrach() {
        return !this.declawed;
    }

    public void poop() {
        weight -= 1;
    }

}
