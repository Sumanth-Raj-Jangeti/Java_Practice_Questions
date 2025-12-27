public class Arrays5 {
    public static void main(String[] args) {
        //LUC an array contains integers & special chars - WAP to print only integers & their sum...
        String[] arr={"12","@","456","&","%","10","#$%"};
        filterInts(arr);
        String[] arr1={"ab12cd34","100","@","$","a1b2","12"};
        extractInts(arr1);
    }
    public static void filterInts(String[] arr)
    {
        int sum=0;
        System.out.println("Integer values in an arr:");
        for(String s:arr)
        {
            try //tries to convert String to Integer...
            {
                int nums=Integer.parseInt(s);
                System.out.println(nums);
                sum+=nums;
            }
            catch (NumberFormatException e)
            {
                // Ignore non-integer values.
            }
        }
        System.out.println("Total Integer Values in arr:"+sum);
    }
    public static void extractInts(String[] arr1)
    {
        int sum=0;
        System.out.println("Integer Values in arr1:");
        for (String s : arr1) {
            // remove everything except digits
            String digits = s.replaceAll("[^0-9]", "");  //You can also use "//D"
            if (!digits.isEmpty()) {
                int numbers = Integer.parseInt(digits);
                sum+=numbers;
                System.out.println(numbers);
            }
        }
        System.out.println("Total Integer Values in arr1:"+sum);
    }
}
