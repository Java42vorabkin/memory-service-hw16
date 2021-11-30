package telran.util.memory;

// VM arguments (Run/Run Configurations/Arguments
// -Xmx5000m -Xms500m

public class MemoryService {

	public static int getMaxAvailableMemory() {
		long maxMemory = Runtime.getRuntime().maxMemory();
		int right = maxMemory>Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)maxMemory;

		int maxAvailableMemory=0;
		int left = 0;
		int middle = 0;
		byte ar[] = null;
		
		while (left <= right) {
			middle = (int) ((left + (long)right) / 2);
			try {
				ar = new byte[middle];
				maxAvailableMemory = middle;
				left = middle + 1;
				ar = null;
			} catch (OutOfMemoryError e) {
				right = middle - 1;
			}
		}
		return maxAvailableMemory;
		 
	}
}
