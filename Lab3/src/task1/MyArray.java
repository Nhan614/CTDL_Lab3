package task1;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}
	// task 1_1
	// To find the index of the target in the array. If the target
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				return i;
			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	public int help(int taget, int index) {
		if (index >= array.length) {
			return -1;
		}
		if (array[index] == taget) {
			return index;
		}

		return help(taget, index+1);
	}

	public int recursiveLinearSearch(int target) {
		return help(target, 0);
	}
	//task 1_2
	// To find the index of the target in the sorted array
	public int iterativeBinarySearch(int target) {
	    int left = 0;
	    int right = array.length - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (array[mid] == target) {
	            return mid;
	        } else if (array[mid] < target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return -1;
	}
	// To find the index of the target in the sorted array
	public int recursiveBinarySearch(int target) {
	    return recursiveBinarySearchHelper(target, 0, array.length - 1);
	}

	private int recursiveBinarySearchHelper(int target, int left, int right) {
	    if (left > right) {
	        return -1;
	    }
	    int mid = left + (right - left) / 2;
	    if (array[mid] == target) {
	        return mid;
	    } else if (array[mid] < target) {
	        return recursiveBinarySearchHelper(target, mid + 1, right);
	    } else {
	        return recursiveBinarySearchHelper(target, left, mid - 1);
	    }
	}
	//task 1_3
	public int deiterativeBinarySearch(int target) {
		int mid = array.length / 2;
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (target > array[mid]) {
				right = mid - 1;
				mid = (right - left) / 2;
			}
			if (target < array[mid]) {
				left = mid + 1;
				mid = array.length - 1 - ((right - left) / 2);
			}
			if (target == array[mid]) {
				return mid;
			}
			if (right == left && target == array[mid]) {
				return right;
			}
		}
		return -1;
	}
	public static void main(String[] args) {

		int[] arr1 = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] arr2 = { 12, 13, 14, 20, 26, 45, 60, 75 };
		int[] arr3 = { 50, 46, 37, 34, 29, 28, 17, 13, 10 }; 
		
		MyArray m1 = new MyArray(arr1);
		MyArray m2 = new MyArray(arr2);
		MyArray m3 = new MyArray(arr3);

		System.out.println(m1.iterativeLinearSearch(45));
		System.out.println(m1.recursiveLinearSearch(10));
		
		System.out.println(m2.iterativeBinarySearch(13));
		System.out.println(m2.recursiveBinarySearch(45));
		
		System.out.println(m3.deiterativeBinarySearch(10));
		System.out.println(m3.deiterativeBinarySearch(46));
	}
}
