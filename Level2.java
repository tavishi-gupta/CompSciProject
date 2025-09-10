import mayflower.*;


public class Level2 extends World {

    private Cat cat;
    private String[][] tiles;
    
    public Level2() 
    {
       Mayflower.showBounds(true);
       setBackground("img/BG/BG1.png");
       
        
        //cat = new Cat();
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
       addMainCharacter();
       buildWorld();
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
        tiles[3][5] = "ground";
        tiles[3][6] = "ground";
        
        tiles[2][3] = "ground";
        
        tiles[1][0] = "ground";
        tiles[1][1] = "ground";
        tiles[1][2] = "ground";
    }
    
    public void buildWorld() {
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                if (tiles[r][c].equals("ground")) {
                    Block block = new Block();
                    block.scale(100, 100);
                    addObject(block, c*100, r*100);
                }
                
                if (tiles[r][c].equals("cat")) {
                    addObject(cat, c*100, r*100);
                }
                
                
            }
        }
    }
   //
    //public void addRandomObjects() {
        //for(int r = 1; r < tiles.length-1; r++) {
            //for (int c = 0; c < tiles[r].length; c++) {
                //int num = (int) (Math.random()*tiles[r].length);
                //if (num < 3) {
                    //tiles[r][c] = "yarn";
                //}
                //if (num > 5) {
                    //tiles[r][c] = "villain";
                //}
            //}
        //}
    //}
    
    public void addMainCharacter() {
        cat = new Cat();
        boolean added = false;
        while (added == false) {
            int row = (int) (Math.random()*tiles.length);
            int col = (int) (Math.random()*tiles[0].length);
            if (tiles[row][col].equals("")){
                tiles[4][0] = "cat";
                added = true;
            }
        }
        
        
        
    }
    
    public void act()
    {
    }
    
}