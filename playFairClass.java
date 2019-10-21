
package caeserclass;


public class playFairClass {
    public static String format(String old_text)
    {
       
        int len;
        String text = new String();
        len = old_text.length();
        for (int tmp = 0; tmp < len; tmp++)
        {
            if (old_text.charAt(tmp) == 'j')
            {
                text = text + 'i';
            }
            else
                text = text + old_text.charAt(tmp);
        }
         
        len = text.length();
        for(int i = 0; i < len; i = i + 2)
        {
            if (text.charAt(i + 1) == text.charAt(i))
            {
                text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
            }
        }
      
        return text;
    }
    
     public static String[] Divid2Pairs(String new_string) 
    {
        String Original = format(new_string);
        int size = Original.length();
        if (size % 2 != 0)
        {
            size++;
            Original = Original + 'x';
        }
        String x[] = new String[size / 2];
        int counter = 0;
        for (int i = 0; i < size / 2; i++)
        {
            x[i] = Original.substring(counter, counter + 2);
            counter += 2;
        }
        return x;
    }
     public static char[][] setMatrix(String k)
    {
        String K_adjust = new String();
        boolean flag = false;
        K_adjust = K_adjust+k.charAt(0);
        for (int i = 1; i < k.length(); i++)
        {
            for (int j = 0; j < K_adjust.length(); j++)
            {
                if (k.charAt(i) == K_adjust.charAt(j))
                {
                    flag = true;
                }
            }
            if (flag == false)
                K_adjust = K_adjust + k.charAt(i);
            flag = false;
        }
        
        boolean f = true;
        char current;
        String key =K_adjust;
        for (int i = 0; i < 26; i++)
        {
            current = (char) (i + 97);
            if (current == 'j')
                continue;
            for (int j = 0; j < K_adjust.length(); j++)
            {
                if (current == K_adjust.charAt(j))
                {
                    f = false;
                    break;
                }
            }
            if (f)
                key = key + current;
            f = true;
        }
        char[][] matrix =new char[5][5];
        int counter = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                matrix[i][j] = key.charAt(counter);
                counter++;
            }
         
        }
        return matrix;
    }
     public static int[] GetDiminsions(char letter,char[][] m)
    {
        int[] key = new int[2];
        
        if (letter == 'j')
            letter = 'i';
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (m[i][j] == letter)
                {
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }
     public static  String encryptMessage(String plain,String key)
    {
        String src_arr[] = Divid2Pairs(plain);
        char[][] m=setMatrix(key) ;
        String cipher = new String();
        char one;
        char two;
        int part1[] = new int[2];
        int part2[] = new int[2];
        for (int i = 0; i < src_arr.length; i++)
        {
            one = src_arr[i].charAt(0);
            two = src_arr[i].charAt(1);
            part1 = GetDiminsions(one,m);
            part2 = GetDiminsions(two,m);
            if (part1[0] == part2[0])
            {
                if (part1[1] < 4)
                    part1[1]++;
                else
                    part1[1] = 0;
                if (part2[1] < 4)
                    part2[1]++;
                else
                    part2[1] = 0;
            }
            else if (part1[1] == part2[1])
            {
                if (part1[0] < 4)
                    part1[0]++;
                else
                    part1[0] = 0;
                if (part2[0] < 4)
                    part2[0]++;
                else
                    part2[0] = 0;
            }
            else
            {
                int temp = part1[1];
                part1[1] = part2[1];
                part2[1] = temp;
            }
           cipher = cipher + m[part1[0]][part1[1]]
                    + m[part2[0]][part2[1]];
        }
        return cipher;
    }
     public static String decryptMessage(String cipher,String key)
    {
        String plain = new String();
        char[][] m =setMatrix(key);
        String x[] = Divid2Pairs(cipher);
        char one;
        char two;
        int part1[] = new int[2];
        int part2[] = new int[2];
        for (int i = 0; i < x.length; i++)
        {
            one = x[i].charAt(0);
            two = x[i].charAt(1);
            part1 = GetDiminsions(one,m);
            part2 = GetDiminsions(two,m);
            if (part1[0] == part2[0])
            {
                if (part1[1] > 0)
                    part1[1]--;
                else
                    part1[1] = 4;
                if (part2[1] > 0)
                    part2[1]--;
                else
                    part2[1] = 4;
            }
            else if (part1[1] == part2[1])
            {
                if (part1[0] > 0)
                    part1[0]--;
                else
                    part1[0] = 4;
                if (part2[0] > 0)
                    part2[0]--;
                else
                    part2[0] = 4;
            }
            else
            {
                int temp = part1[1];
                part1[1] = part2[1];
                part2[1] = temp;
            }
            plain = plain +m[part1[0]][part1[1]]
                    + m[part2[0]][part2[1]];
        }
        return plain;
    }
}
