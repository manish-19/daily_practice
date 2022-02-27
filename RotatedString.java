class RotateStringDemo { 

public static boolean isRotatedVersion(String str, String rotated) { 
        boolean isRotated = false; 
        if (str == null || rotated == null) { 
              return false; 
        } 
        else if (str.length() != rotated.length()) { 
        isRotated = false; 
        } 
        else { 
        String concatenated = str + str; 
        isRotated = concatenated.contains(rotated); 
        } 
        return isRotated; 
      }
      public static void main(String args[]) { 
                 String test = "abcd"; 
                 String rotated = "dabc"; 
                 boolean isRotated = isRotatedVersion(test, rotated); 
       }
}
