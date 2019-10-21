
package caeserclass;


public class CaeserClass {
    public static String encrypt(String text, int s) 
    { 
        String result= ""; 
  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                result+= (char)(((int)text.charAt(i) + 
                                  s - 65) % 26 + 65); 
               
            } 
            else
            { 
                result+= (char)(((int)text.charAt(i) + 
                                  s - 97) % 26 + 97); 
                
            } 
        } 
        return result;
    }


    public static String decrypt(String text, int s) 
    { 
        String result= ""; 
  
          for (int i=0; i<text.length(); i++) 
              { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                result+= (char)(((int)text.charAt(i) - 
                                  s -65) % 26 +65); 
               
            } 
            else
            { 
                result+= (char)(((int)text.charAt(i) - 
                                  s - 97) % 26 +97); 
                
            } 
        } 
        return result;
    }
}
