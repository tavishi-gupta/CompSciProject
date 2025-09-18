import mayflower.*;


public class Level2 extends World {

    private Cat cat;
    private String[][] tiles;
    
    public Level2() 
    {
       Mayflower.showBounds(true);
       setBackground("img/BG/BG1.png");
       
        
       cat = new Cat();
       // addObject(cat, 100, 100);
        //dog = new Dog();
        //addObject(dog, 200, 200);
        //jack = new Jack();
        //addObject(jack, 500, 300);
        //ninja = new Ninja();
        //addObject(ninja, 400, 400);
       tiles = new String[6][8];
        
       createTiles();
        //addRandomObjects();
       //addMainCharacter();
       buildWorld();
       showText("Score: ? Lives: ?", 10, 30, Color.BLACK);
    }
    
    public void createTiles() {
        for(int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                tiles[r][c] = "";
            }
        }
        
        for(int i = 0; i < tiles[0].length; i++) {
            tiles[5][i] = "ground";
        }
        
        tiles[3][4] = "ground";
        tiles[3][5] = "stove";
        tiles[3][6] = "ground";
        
        tiles[5][3] = "stove";
        
        tiles[3][0] = "ground";
        tiles[2][0] = "salt";
        
        tiles[1][3] = "ladder";
        tiles[2][3] = "ladder";
        tiles[3][3] = "ladder";
        
        tiles[4][1] = "ladder";
        tiles[3][1] = "ladder";
        
        tiles[1][0] = "ground";
        tiles[1][1] = "ground";
        tiles[1][2] = "ground";
        
        tiles[4][7] = "ladder";
        tiles[3][1] = "ladder";
        
        tiles[2][4] = "lemon";
        tiles[4][6] = "chips";
        tiles[0][0] = "avocado";
        tiles[4][2] = "onion";
        tiles[4][0] = "cat";
    }
    
    
    public void buildWorld() {
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                if (tiles[r][c].equals("ground")) {
                    Block block = new Block();
                    block.scale(100, 100);
                    addObject(block, c*100, r*100);
                }
                if (tiles[r][c].equals("stove")){
                    addObject(new Stove(), c * 100, r*100);
                }
                if (tiles[r][c].equals("avocado")) {
                    addObject(new Avocado(), c*100, r*100);
                }
                
                if (tiles[r][c].equals("onion")) {
                    addObject(new Onion(), c*100, r*100);
                }
                
                if (tiles[r][c].equals("lemon")) {
                    addObject(new Lemon(), c*100, r*100);
                }
                
                if (tiles[r][c].equals("salt")) {
                    addObject(new Salt(), c*100, r*100);
                }
                
                if (tiles[r][c].equals("chips")) {
                    addObject(new Chips(), c*100, r*100);
                }
                if (tiles[r][c].equals("ladder")) {
                    addObject(new Ladder(), c*100, r*100);
                }
                
                if (tiles[r][c].equals("cat")) {
                    addObject(cat, c*100, r*100);
                }
                
            }
        }
    }
 
    
    
    
    public void act()
    {
    }
    
}