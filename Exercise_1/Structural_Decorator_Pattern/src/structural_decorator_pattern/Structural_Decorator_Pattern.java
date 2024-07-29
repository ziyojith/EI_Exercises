/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package structural_decorator_pattern;

/**
 *
 * @author JITHIN V J
 */
// Decorator Pattern

interface Coffee {
    int cost();
}

class BasicCoffee implements Coffee {
    @Override
    public int cost() {
        return 5;
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 2;
    }
}

class SugarDecorator implements Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 1;
    }
}

// Usage
public class Structural_Decorator_Pattern {
    public static void main(String[] args) {
        Coffee basicCoffee = new BasicCoffee();
        System.out.println("Cost of basic coffee: " + basicCoffee.cost());

        Coffee milkCoffee = new MilkDecorator(basicCoffee);
        System.out.println("Cost of coffee with milk: " + milkCoffee.cost());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost of coffee with milk and sugar: " + sugarMilkCoffee.cost());
    }
}

