import mayflower.*;


public class Level1 extends World {

    private Cat cat;
    private String[][] tiles;
    
    public Level1() 
    {
        setBackground("img/BG/BG1.png");
        
        tiles = new String[6][8];
        createTiles();
        buildWorld();

        
        Mayflower.showBounds(true);
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
        
       tiles[4][2] = "eggs";
       tiles[4][4] = "bread";
       tiles[3][6] = "butter";
       tiles[4][0] = "cat";
       tiles[2][3] = "remy";

    }

    public void buildWorld(){
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length; col++)
            {
                Block b = new Block();
                b.scale(100,100);
                if ( tiles[row][col].equals("ground") ){
                    addObject(b, col*100, row*100);
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
                if (tiles[row][col].equals("remy")){
                    addObject(new Remy(), col * 100, row*100);
                }
                
            }
        }
    }


    
}