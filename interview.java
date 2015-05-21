import java.util.Arrays;

class interview {

	public static void main(String [] args) {

		int[] input_array = new int[] {1, 2, 3};

		int[] output_array = new int[input_array.length];

		int x = 1;
		output_array[0] = 1;

		for (int i = 1; i < input_array.length; i++) {
			output_array[i] = output_array[i - 1] * input_array[i - 1];
		}	

		for (int i = input_array.length - 1; i > 0; i--) {
			x = x * input_array[i];
			output_array[i - 1] = x * output_array[i - 1];
		}
			System.out.println(Arrays.toString(output_array));
	}
}