# priyaka
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class AnagramSort{

    public static void main( String[] args ){
        HashMap< Integer, ArrayList< String >> hm = new HashMap();

        groupAnagrams( args, hm );
        System.out.println( hm );
    }


    public static void groupAnagrams( String[] list, HashMap< Integer, ArrayList< String >> hm ){

        for( int x=0; x<list.length; x++ ){
            if( list[ x ] == null ) continue;

            String curX    = list[ x ];
            int    hashX   = primeHash( curX );

            hm.put( hashX, new ArrayList( Arrays.asList( curX )));

            for( int y=x+1; y<list.length; y++ ){

                String curY    = list[ y ];
                int    hashY   = primeHash( curY );

                if( curY == null || curY.length() != curX.length())  continue;

                if( hashX == hashY ){
                    hm.get( hashX ).add( curY );

                    list[ y ] = null; // if its an anagram null it out to avoid checking again
                }
            }
        }
    }

    public static int primeHash( String word ){
        int productOfPrimes = 1;
        int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
            37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

        for( char ch : word.toCharArray() ){
            productOfPrimes *= prime[ (int) ch - (int) 'a' ];
        }
        return productOfPrimes;
    }
    }
