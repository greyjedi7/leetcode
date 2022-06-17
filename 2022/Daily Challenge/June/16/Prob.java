public class Prob {

    String palindrome="";

    public void calculatePalindrome(String s,int index, boolean pair){


        int n = s.length();
        int left;
        int right;
        String result;
        if(pair){
            left = index-1;
            right = index+2;
            result = s.substring(index,index+2);
        } else {
            left = index -1;
            right = index +1;

            result = s.substring(index,index+1);
        }

        while(left >= 0 && right < n){
            if(s.charAt(left) == s.charAt(right)){
                result = s.substring(left,left+1) + result + s.substring(right,right+1);
                left--;
                right++;
            } else {
                break;
            }
        }

        if(result.length() > palindrome.length()){
            palindrome = result;
        }
    }
    

    public String longestPalindrome(String s) {
        int  n = s.length();
        
        for(int i=1;i<n-1;i++){
            calculatePalindrome(s, i, false);
        }

        for(int i=0;i<n-2;i++){
            if(s.charAt(i) == s.charAt(i+1)){
            calculatePalindrome(s, i, true);
            }
        }

        return palindrome;
        
    }

    public static void main(String[] args){
        System.out.println(new Prob().longestPalindrome("fjnfkfbfeuujctmyttwidcrdjtkfoaylsceqqzzmkpyvljkwcxxtmxiwkrgoahxztuppnvxhyionhpakvjoizdzcqxuyaidjadrhfhuhbncijokbthvuigjytipgygnonhgkpvsqimxpslmptieumhunjlafttjstaxnivrpqcxrgocvaicpwfnmtkgbjnbfopxaiduqihomrdmhzzyzddytiqdjzmmqwmeyoqnttmiujobihdifkbntpphjhgxzbjpulnokvceohloltyosddbopgkllcxzzkfzmkywxlpkdjlorgorxzownuajjzcxuhyqexfklssbtralzlvdbtxapccipvvgjtusfsanvnyehpkwirygqogtsicwycgnajwekuzffhlsvfgqwpbuinwhvpqxjhamhxayicchmxmurakhzhoghnupohaqanduhjkegggpyetwebcjgavpspfjaoakjkktaxwehpyqvsczhbbhzcsvqyphewxatkkjkaoajfpspvagjcbewteypgggekjhudnaqahopunhgohzhkarumxmhcciyaxhmahjxqpvhwniubpwqgfvslhffzukewjangcywcistgoqgyriwkpheynvnasfsutjgvvpiccpaxtbdvlzlartbsslkfxeqyhuxczjjaunwozxrogroljdkplxwykmzfkzzxcllkgpobddsoytlolhoecvkonlupjbzxghjhpptnbkfidhibojuimttnqoyemwqmmzjdqityddzyzzhmdrmohiqudiaxpofbnjbgktmnfwpciavcogrxcqprvinxatsjttfaljnuhmueitpmlspxmiqsvpkghnongygpityjgiuvhtbkojicnbhuhfhrdajdiayuxqczdziojvkaphnoiyhxvnpputzxhaogrkwixmtxxcwkjlvypkmzzqqecslyaofktjdrcdiwttymtcjuuefbfkfnjf"
        ));
    }
}