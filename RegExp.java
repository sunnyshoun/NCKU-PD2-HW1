import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MyString{
    private String str;
    private char[] str_arr;

    MyString(String s){
        this.str = s.toLowerCase();
        this.str_arr = s.toCharArray();
    }

    private String GetSubstring(String s, int start, int end){
        char[] s_arr = s.toCharArray();
        String substr = "";
        for(int i=start;i<end;i++){
            substr+=s_arr[i];
        }
        return substr;
    }

    public String IsPalindrome(){
        int str_len = this.str.length();
        for(int i=0;i<str_len/2;i++){
            if(this.str_arr[i] != this.str_arr[str_len-i-1]){
                return "N";
            }
        }
        return "Y";
    }

    public String IsSub(String s){
        for(int i=0;i<this.str.length()-s.length()+1;i++){
            if(this.GetSubstring(str, i, i+s.length()).equals(s)){
                return "Y";
            }
        }
        return "N";
    }

    public String IsContainNum(String s, int n){
        int show_times = 0;
        for(int i=0;i<this.str.length()-s.length()+1;i++){
            if(this.GetSubstring(str, i, i+s.length()).equals(s)){
                show_times += 1;
            }
        }
        return (show_times >= n) ? "Y":"N";
    }

    public String amXb2m(){
        int a_show_times = 0;
        int b_show_times = 0;
        int i = 0;
        while(a_show_times < 1 || b_show_times < 2){
            if(a_show_times == 0){
                if(this.str_arr[i] == 'a') a_show_times = 1;
            }
            else{
                if(this.str_arr[i] == 'b') b_show_times++;
            }
            i++;
        }
        return (a_show_times+b_show_times == 3) ? "Y":"N";
    }
}

public class RegExp {
    
    public static void main(String[] args) {
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        //For your testing of input correctness
        // System.out.println("The input file:"+args[0]);
        // System.out.println("str1="+str1);
        // System.out.println("str2="+str2);
        // System.out.println("num of repeated requests of str2 = "+s2Count);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                //You main code should be invoked here
                // System.out.println(line);
                MyString mystr = new MyString(line);
                System.out.print(mystr.IsPalindrome()+',');
                System.out.print(mystr.IsSub(str1)+',');
                System.out.print(mystr.IsContainNum(str2, s2Count)+',');
                System.out.println(mystr.amXb2m());
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}