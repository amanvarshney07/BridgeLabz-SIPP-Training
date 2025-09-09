class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

class AnimalDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
        
        Animal animal = new Animal();
        animal.makeSound();
        
        Animal animalRef = new Dog();
        animalRef.makeSound();
    }
}