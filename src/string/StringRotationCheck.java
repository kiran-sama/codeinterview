package string;

/**
 * Created by ksama on 12/27/15.
 */
public class StringRotationCheck {
  /*
   * Algorithm: xy,yx
   * yx is part of xyxy
   * xy is part of yxyx
   */
  public static boolean isStringRotated(String s1, String s2){
    String s1s1 = s1+s1;
    return s1s1.contains(s2);
  }

  public static void main(String args[]){
    String s1= "KiranSama";
    String s2 = "SamaKiran";
    System.out.println(isStringRotated(s1,s2));
  }
}
