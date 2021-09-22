package UDP; /**
 * WisdomWords class to be used with the WisdomWords (TCP or UDP) protocol.
 * Loads a file of wise sayings indicated at the command line when the server
 * is started.  
 *
 * Scott Barlowe, Fall 2021
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WisdomWords {

    // holds the wise sayings
    private ArrayList<String> wisdom;

    /**
     * Constructor. Instantiates the ArrayList and 
     * starts the loading process
     *
     * @param: file from the server's command line
     *
     */
    public WisdomWords(String file){

        wisdom = new ArrayList<>();
        ReadSayings(file);

    }

    /**
     * Loads file of wise sayings into string array
     *
     * @param file from the server's command line
     *
     */
    public void ReadSayings(String file){

        try{
            Scanner sc = new Scanner(new File(file));
            
            while(sc.hasNextLine()){
               
                wisdom.add(sc.nextLine());
            }

            sc.close();
        }
        catch(IOException e){

            System.out.println("Had trouble loading file...");
        }


    }

    /**
     * Returns the wise saying at the index
     *
     * @return Wise saying as a string or empty string if the index is out
     * of bounds. 
     */
    public String getWisdom(int index){

        String toReturn = "";

        if(index < getSize()){
            toReturn = wisdom.get(index);     
        }
        return toReturn;
    }

    /**
     * Returns the size of the ArrayList
     *
     * @return integer
     */
    public int getSize(){

        return wisdom.size();
    }

}
