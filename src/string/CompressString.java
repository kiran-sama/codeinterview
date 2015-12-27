package string;

/**
 * Created by ksama on 12/27/15.
 */
public class CompressString {

  public static String compressString(String plaintext){
    StringBuffer buffer = new StringBuffer();
    int count =0;
    char lastChar = ' ';
    for(int i=0;i<plaintext.length();i++){
      if(plaintext.charAt(i)== lastChar){
        count++;
      }else{
        if(count!=0) {
          buffer.append(count);
        }
        lastChar = plaintext.charAt(i);
        buffer.append(plaintext.charAt(i));
        count =1;
      }
    }
    return plaintext.length()<buffer.length()?plaintext:buffer.toString();
  }

  public static void main(String[] args){
     System.out.println(compressString("jhdfjgfdhgfdhjfhgfhgfsfffffghjjj"));
     System.out.println(compressString("GGHGbbbshgfGGG"));
     System.out.println(compressString("aaab"));
  }
}
