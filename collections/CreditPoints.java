import java.util.*;
class CreditPoints
{
	public int[] creditPoints(int[] nums) {
        int length = nums.length;
        int[] credits = new int[length];
        credits[0] = 1;
        for (int i = 1; i < length; i++) {
            credits[i] = nums[i - 1] * credits[i - 1];
        }
        return credits;
    }
    public static void main(String args[] ) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] numberline = str.split(" ");
		int[] nums = Arrays.asList(numberline).stream().mapToInt(Integer::parseInt).toArray();
		int[] credits=new CreditPoints().creditPoints(nums);
		for(int credit : credits)
		System.out.print( credit +" ");   
	}
}