package Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DaySo {

	// Tìm UCLN, BCNN
	public static int UCLN(int a, int b) {
		int r;
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static int BCNN(int a, int b) {
		return a * b / UCLN(a, b);
	}

	// Tính tổng số nguyên bất kì
	public static int tongSoNguyen(int a) {
		int res = 0;
		while (a > 0) {
			res += a % 10;
			a /= 10;
		}
		return res;
	}

	// Kiểm tra số nguyên tố
	public static boolean checkSNT(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// Phân tích một số thành tích các số nguyên tố
	public static void phanTich(int n) {
		int dem = 2;
		String s = "";
		while (n > 1) {
			if (n % dem == 0) {
				n /= dem;
				s += dem + "*";
			} else {
				dem++;
			}
		}
		System.out.println(s.substring(0, s.length() - 1));
	}

	// Liệt kê các số nguyên tố nhỏ hơn n với n nhập từ bàn phím
	public static void lietKeSNT() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n = ");
		int n = sc.nextInt();
		List<Integer> listSNT = new ArrayList<>();
		for (int i = 2; i < n; i++) {
			if (checkSNT(i))
				listSNT.add(i);
		}
		for (Integer integer : listSNT) {
			System.out.print(integer + " ");
		}
		sc.close();
	}

	// Kiểm tra số chính phương
	public static boolean checkSCP(int n) {
		int cbh = (int) Math.sqrt(n);
		if (cbh * cbh == n)
			return true;
		return false;
	}

	// Tìm số fibo thứ n
	public static int fibo(int n) {
		if (n < 2)
			return n;
		int f1 = 1, f2 = 0;
		for (int i = 2; i < n; i++) {
			int f0 = f1 + f2;
			f2 = f1;
			f1 = f0;
		}
		return f1 + f2;
	}

	// Kiểm tra năm nhuận
	public static boolean checkNamNhuan(int nam) {
		if (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0))
			return true;
		return false;
	}

	// Kiểm tra số thuận nghịch
	public static boolean checkSoThuanNgich(int n) {
		StringBuilder xau = new StringBuilder();
		String str = "" + n;
		xau.append(str);
		String check = "" + xau.reverse();
		if (str.equals(check))
			return true;
		else
			return false;
	}

	// Liệt kê số thuận nghịch có 6 chữ số
	public static void lietKeSoThuanNghich() {
		for (int i = 10000; i < 100000; i++) {
			if (checkSoThuanNgich(i))
				System.out.print(i + " ");
		}
	}

	// Tìm phần tử lớn nhất trong mảng
	public static int timMaxArray(int A[], int l, int r) {
		if (l == r) {
			int max = A[l];
			return max;
		} else {
			int mid = (l + r) / 2;
			int x = timMaxArray(A, l, mid);
			int y = timMaxArray(A, mid + 1, r);
			return x > y ? x : y;
		}
	}

	// Tìm kiếm nhị phân (Tìm kiếm trên mảng đã được sắp xếp)
	public static int binarySearch(int a[], int l, int r, int k) {
		if (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] == k)
				return mid;
			if (a[mid] > k)
				return binarySearch(a, l, mid - 1, k);
			if (a[mid] < k)
				return binarySearch(a, mid + 1, r, k);
		}
		return -1;
	}

	// Sắp xếp nổi bọt
	public static void sapXepNoiBot(int a[], int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					int tg = a[i];
					a[i] = a[j];
					a[j] = tg;
				}
			}
		}
	}

	// Sắp xếp nhanh
	public static int partition(int a[], int low, int high) {
		int pivot = a[high];
		int left = low;
		int right = high - 1;
		while (true) {
			while (left <= right && a[left] < pivot)
				left++;
			while (right >= left && a[right] > pivot)
				right--;
			if (left >= right)
				break;
			int tg = a[left];
			a[left] = a[right];
			a[right] = tg;
			left++;
			right--;
		}
		int tg = a[left];
		a[left] = a[high];
		a[high] = tg;
		return left;
	}

	public static void quickSort(int a[], int low, int high) {
		while (low < high) {
			int index = partition(a, low, high);
			quickSort(a, low, index - 1);
			quickSort(a, index + 1, high);
		}
	}

	// hàm xuất mảng
	public static void xuatMang(int a[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// Tính giai thừa
	public static int giaiThua(int n) {
		if (n < 2)
			return 1;
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	// Tính lũy thừa
	public static long luyThua(int a, int n) {
		long x;
		if (n == 1)
			return a;
		x = luyThua(a, n / 2);
		if (n % 2 == 0)
			return x * x;
		else
			return x * x * a;
	}

	// Tìm phần tử âm lớn nhất trong mảng
	public static void timMaxAmTrongMang(int a[], int n) {
		int M = Integer.MIN_VALUE;
		boolean Q = false;
		for (int i = 0; i < n; i++) {
			if (a[i] > 0)
				continue;
			Q = true;
			if (a[i] > M)
				M = a[i];
		}
		if (Q = false) {
			System.out.println("Mang khong co phan tu am");
		} else {
			System.out.println("Phan tu am lon nhat cua mang la: " + M);
		}
	}

	// Tìm phần tử dương bé nhất trong mảng
	public static void timMinDuongTrongMang(int a[], int n) {
		int M = Integer.MAX_VALUE;
		boolean Q = false;
		for (int i = 0; i < n; i++) {
			if (a[i] <= 0)
				continue;
			Q = true;
			if (a[i] < M)
				M = a[i];
		}
		if (Q == false)
			System.out.println("Mang k co phan tu duong");
		else
			System.out.println("Phan tu duong be nhat cua mang la: " + M);
	}

	// Liệt kê các phần tử xuất hiện trong dãy đúng 1 lần
	public static int countElem(int a[], int n, int k) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == k)
				count++;
		}
		return count;
	}

	public static void lietKe(int a[], int n) {
		for (int i = 0; i < n; i++) {
			if (countElem(a, n, a[i]) == 2 && countElem(a, i, a[i]) == 0) {
				System.out.print(a[i] + " ");
			}
		}
	}

	// Đếm số lần các phần tử xuất hiện trong dãy
	public static void lietKe2(int a[], int n) {
		for (int i = 0; i < n; i++) {
			if (countElem(a, i, a[i]) == 0)
				System.out.println(a[i] + " " + countElem(a, n, a[i]));
		}
	}

	// Liệt kê các số có 5 chữ số vừa là số nguyên tố vừa có tổng các chữ số bằng 5
	public static void lietKe3() {
		for (int i = 10000; i < 100000; i++) {
			if (checkSNT(i) == true && tongSoNguyen(i) == 5) {
				System.out.print(i + " ");
			}
		}
	}

	// Liệt kê các số fibo nhỏ hơn 1000 là số nguyên tố
	public static void lietKe4() {
		int i = 0;
		while (true) {
			if (fibo(i) < 10000 && checkSNT(fibo(i)) == true) {
				System.out.print(fibo(i) + " ");
			}
			if (fibo(i) >= 10000)
				break;
			i++;
		}
	}

	// Liệt kê các ước số của 100, đếm số ước, liệt kê các ước là số nguyên tố
	public static void lietKe5() {
		String uoc = "";
		int dem = 0;
		String uocNT = "";
		for (int i = 1; i <= 100; i++) {
			if (100 % i == 0) {
				dem++;
				uoc += i + " ";
				if (checkSNT(i) == true) {
					uocNT += i + " ";
				}
			}
		}
		System.out.println(uoc + " " + dem);
		System.out.println(uocNT);
	}

	// Liệt kê n số fibo đầu tiên
	public static void lietKe6() {
		int dem = 1;
		while (dem <= 10) {
			System.out.print(fibo(dem) + " ");
			dem++;
		}
	}

	// Liệt kê n số nguyên tố đầu tiên
	public static void lietKe7() {
		int dem = 1;
		int so = 2;
		while (dem <= 10) {
			if (checkSNT(so) == true) {
				System.out.print(so + " ");
				dem++;
			}
			so++;
		}
	}

	public static boolean checkDB(int n) {
		int res = 0;
		while (n > 0) {
			res = n % 10;
			n /= 10;
			if (checkSNT(res) == false)
				return false;
		}
		return true;
	}

	// Liệt kê các số nguyên tố có 3 chữ số mà mỗi chữ số đều là số nguyên tố
	public static void lietKe8() {
		for (int i = 100; i < 1000; i++) {
			if (checkDB(i) == true && checkSNT(i) == true) {
				System.out.print(i + " ");
			}
		}
	}

	// Liệt kê các số thuận nghịch có 7 chữ số mà tổng các chữ số là số thuận nghịch
	public static void lietKe9() {
		for (int i = 1000000; i < 10000000; i++) {
			if (checkSoThuanNgich(i) == true && checkSoThuanNgich(tongSoNguyen(i)) == true) {
				System.out.print(i + " ");
			}
		}
	}

	// Tìm phần tử lớn nhất và lớn thứ 2 trong mảng
	public static int viTriMaxInt(int a[], int n) {
		int max = a[0];
		int key = 0;
		for (int j = 0; j < n; j++) {
			if (max < a[j]) {
				max = a[j];
				key = j;
			}
		}
		return (key);
	}

	public static int viTriMax2(int[] a, int n) {
		int i, key = 0, Max2 = 0;
		for (i = 0; i < n; i++) {
			if (a[i] > Max2 && a[i] != a[viTriMaxInt(a, n)]) {
				Max2 = a[i];
				key = i;
			}
		}
		return (key);
	}

	public static void tim(int a[], int n) {
		for (int i = 0; i < n; i++) {
			if (a[i] == a[viTriMaxInt(a, n)])
				System.out.println(a[i]);
		}
		for (int i = 0; i < n; i++) {
			if (a[i] == a[viTriMax2(a, n)])
				System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
//		System.out.println(UCLN(10,8));
//		System.out.println(BCNN(10,8));
//		System.out.println(tongSoNguyen(12345));
//		System.out.println(checkSNT(5));
//		phanTich(120);
//		lietKeSNT();
//		System.out.println(checkSCP(17));
//		System.out.println(fibo(5));
//		System.out.println(checkNamNhuan(2020));
//		System.out.println(checkSoThuanNgich(121));
//		lietKeSoThuanNghich();
//		int a[] = {1,2,5,4,5,6,9,10, 12,-4};
//		int n = a.length;
//		System.out.println(timMaxArray(a, 0, n-1));
//		int a1[] = {1,2,3,4,5,6,7,8,9,10,11};
//		System.out.println(binarySearch(a1, 0, a1.length - 1, 10));
//		List<Integer> listA = new ArrayList<>();
//		for (int i : a) {
//			listA.add(i);
//		}
//		Collections.sort(listA);
//		for (Integer i : listA) {
//			System.out.print(i + " ");
//		}
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Nhap n = ");
//		int n = sc.nextInt();
//		int a[] = new int[n];
//		for(int i = 0; i < n; i++) {
//			a[i] = sc.nextInt();
//		}
//		quickSort(a, 0, n-1);
//		sapXepNoiBot(a, n);
//		xuatMang(a, n);
//		sc.close();	
//		System.out.println(giaiThua(6));s
//		System.out.println(luyThua(3, 4));
//		timMaxAmTrongMang(a, n);
//		timMinDuongTrongMang(a, n);
//		lietKe(a, n);
//		lietKe2(a, n);
//		lietKe3();
//		lietKe4();
//		lietKe5();
//		lietKe6();
//		lietKe7();
//		lietKe8();
//		lietKe9();
//		tim(a, n);
//		List<Integer> l = new ArrayList<>();
//		int a[] = { 10, 2, 6, 4, 11, 9, 8, 7 };
//		int n = 8;
//		for(int i = 0; i < n; i++) {
//			l.add(a[i]);
//		}
//		Collections.sort(l);
//		for (Integer i : l) {
//			System.out.print(i + " ");
//		}
	}
}
