import mayflower.*;


public class Level1 extends World {

    private Cat cat;
    private Block block;
    private Block block2;
    private String[][] tiles;
    private int lowx;
    private int lowy;
    private int highx;
    private int highy;
    
    public Level1() 
    {
       
        
        setBackground("img/BG/BG1.png");
        
        tiles = new String[6][8];
        createTiles();
        buildWorld();

        lowx = 0;
        lowy = 50;
        highx = 300;
        highy = 100;
        
        Mayflower.showBounds(true);
        showText("Score: ? Lives: ?", 10, 30, Color.BLACK);
    }
    
    public void act()
    {
    }
    
    public void createTiles(){
        for (int r = 0; r < tiles.length; r++){
            for (int c = 0; c < tiles[r].length; c++){
                tiles[r][c] = "";
            }
        }

        for (int i=0; i<tiles[0].length; i++)
        {
            tiles[5][i] = "ground";
        }
        
        for (int i = 5; i<tiles[0].length; i++){
            tiles[4][i] = "ground";
        }
        
        for (int i = 1; i<5; i++){
            tiles[3][i] = "ground";
        }
       
       tiles[3][3] = "stove";
       tiles[4][2] = "eggs";
       tiles[4][4] = "bread";
       tiles[3][6] = "butter";
       tiles[4][1] = "cat";
       tiles[4][0] = "ladder";
       tiles[3][0] = "ladder";
       tiles[1][1] = "remy";

    }
    
    
    public void buildWorld(){
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length; col++)
            {
                if ( tiles[row][col].equals("ground") ){
                    addObject(new Block(), col*100, row*100);
                }
                if (tiles[row][col].equals("stove")){
                    addObject(new Stove(), col * 100, row*100);
                }
                if (tiles[row][col].equals("cat")){
                    addObject(new Cat(), col * 100, row*100);
                }
                
                if (tiles[row][col].equals("eggs")){
                    addObject(new Eggs(), col * 100, row*100);
                }
                if (tiles[row][col].equals("bread")){
                    addObject(new Bread(), col * 100, row*100);
                }
                if (tiles[row][col].equals("butter")){
                    addObject(new Butter(), col * 100, row*100);
                }
                if (tiles[row][col].equals("ladder")){
                    addObject(new Ladder(), col * 100, row*100);
                }
                if ( tiles[row][col].equals("remy") ){
                    Remy remy = new Remy();
                    remy.setRemyBounds(lowx, lowy, highx, highy);
                    addObject(remy, col*100, row*100);
                }
                
            }
        }
    }
    
    


    
}