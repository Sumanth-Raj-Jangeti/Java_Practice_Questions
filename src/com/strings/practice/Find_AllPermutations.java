package com.strings.practice;

public class Find_AllPermutations {
    public static void main(String[] args){
        String str = "aab";
        String[] permutations = findPermutations(str);
        for(String permutation: permutations){
            if (permutation!=null)
                System.out.println(permutation);
        }
    }
    public static String[] findPermutations(String str){
        int size=6;
        String[] result = new String[size];
        //converting str to char[].
        char[] chars=str.toCharArray();
        int index=0;
        for(int i=0;i<chars.length;i++)
        {
            for(int j=0;j<chars.length;j++)
            {
                for(int k=0;k<chars.length;k++)
                {
                    if(i!=j && j!=k && i!=k)
                    {
                        String permutation=""+chars[i]+chars[j]+chars[k]; //"" are mandatory otherwise java will add ASCII values
                        if (!isDuplicate(result, permutation, index)) {
                            result[index++] = permutation;
                        }
                    }
                }
            }
        }
        return result;
    }
    public static boolean isDuplicate(String[] result, String perm, int size) {
        for (int i = 0; i < size; i++) {
            if (result[i].equals(perm)) {
                return true;
            }
        }
        return false;
    }
}



