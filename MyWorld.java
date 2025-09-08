import mayflower.*;


public class MyWorld extends World {

	private Cat cat;
	private Dog dog;
	private Ninja ninja;
	private Jack jack;
	private Block block;
	private Block block2;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	
    	cat = new Cat();
    	addObject(cat, 400, 100);

    	
    	// dog = new Dog();
    	// addObject(dog, 200, 100);
    	// ninja = new Ninja();
    	// addObject(ninja, 300, 100);
    	// jack = new Jack();
    	// addObject(jack, 400, 100);
    	
    	block = new Block();
    	addObject(block, 400, 500);
    	block2 = new Block();
    	addObject(block2, 538, 372);
    	
    	Mayflower.showBounds(true);
    }
    
    public void act()
    {
    }
    
}