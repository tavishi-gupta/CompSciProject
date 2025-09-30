

import mayflower.*;

public class Level3 extends World {
    private Cat cat;
    private String[][] tiles;
    public Level3() 
    { 
        this(new Cat());
    }
    
    public Level3(Cat c) 
    {

        setBackground("img/BG/BG1.png");
        cat = c;
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

        for (int i = 0; i<3; i++){
            tiles[3][i] = "ground";
        }

        for (int i = 3; i<5; i++){
            tiles[2][i] = "ground";
        }
        
        tiles[2][3] = "stove";
        tiles[4][2] = "eggs";
        tiles[4][4] = "sugar";
        tiles[3][6] = "flour";
        tiles[2][0] = "chocolate";
        tiles[1][4] = "baking soda";
        tiles[1][2] = "milk";
        tiles[4][7] = "icing";
        tiles[4][5] = "ladder";
        tiles[3][5] = "ladder";
        tiles[2][5] = "ladder";
        tiles[4][6] = "ground";
        tiles[3][1] = "stove";
        tiles[0][0] = "cat";
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
                if (tiles[row][col].equals("stove")){
                    addObject(new Stove(), col * 100, row*100);
                }
                

                if (tiles[row][col].equals("eggs")){
                    addObject(new Eggs(), col * 100, row*100);
                }
                if (tiles[row][col].equals("chocolate")){
                    addObject(new Chocolate(), col * 100, row*100);
                }
                if (tiles[row][col].equals("flour")){
                    addObject(new Flour(), col * 100, row*100);
                }
                if (tiles[row][col].equals("milk")){
                    addObject(new Milk(), col * 100, row*100);
                }
                if (tiles[row][col].equals("baking soda")){
                    addObject(new BakingSoda(), col * 100, row*100);
                }
                if (tiles[row][col].equals("icing")){
                    addObject(new Icing(), col * 100, row*100);
                }
                if (tiles[row][col].equals("sugar")){
                    addObject(new Sugar(), col * 100, row*100);
                }
                if (tiles[row][col].equals("ladder")){
                    addObject(new Ladder(), col * 100, row*100);
                }
                if (tiles[row][col].equals("cat")){
                    addObject(cat, col * 100, row*100);
                }

            }
        }
    }

}
