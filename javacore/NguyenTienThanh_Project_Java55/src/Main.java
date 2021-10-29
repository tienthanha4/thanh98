import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataIO.dataRoot = "C:\\Users\\Admin\\Desktop\\Java(th)\\BaiTapCuoiKHhoa_JavaCore\\QuanLySinhVien\\data";

		DataIO.loadData();
		ArrayList<SinhVien> dsSV = DataIO.dsSinhVien;
		ArrayList<MonHoc> dsMh = DataIO.dsMonHoc;
		ArrayList<Diem> dsDiem = DataIO.dsDiem;
		int size = DataIO.dsSinhVien.size();
		int gioiHan = size/5;
		
		Scanner sc = new Scanner(System.in);
		int chon;
		do {
			// in menu
			printMenu1();
			// nhap lua chon
			System.out.println("nhap lua chon :");
			chon = sc.nextInt();
			switch (chon) {
			case 1: {

				updateListSV(dsSV, dsMh);

				break;
			}
			
			case 3:
				timKiem(dsDiem, dsMh, dsSV);
				break;
			case 0: {
				//DataIO.saveAllData(dsSV, dsMh, dsDiem);
				DataIO.saveAllData(dsSV, dsMh, dsDiem);
				System.out.println("oke");
				break;
			}
			case 2: {
				
				hienThiPhanTrang(dsDiem, dsMh, dsSV);
				
				break;				
			    
			}
			
				
			case 5 : 
				
				break;

			default:
				System.out.println("SAI YEU CAU");

			}
		} while (chon != 0);
	}

	private static void hienThiPhanTrang(ArrayList<Diem> dsDiem, ArrayList<MonHoc> dsMh, ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		int chon;
		int x = dsSV.size()/30;
		System.out.println(x);
		System.out.println("Chon:");
		Scanner sc = new Scanner(System.in);
		int trang = 0;
		//hienThiBangDiem(dsDiem, dsMh, dsSV, trang);
		hienThiBangDiem1(dsDiem, dsMh, dsSV,0);
		do {
			
			
			System.out.println();
			
			if(trang<dsSV.size())
			{
			System.out.format(" %-32s", "1. trang sau");
			}
			if(trang>0)
			{
			System.out.format(" %-32s ", "2. trang truoc");
			}
			System.out.format(" %-32s ", "3. trang cuoi");
			System.out.format(" %-32s ", "4. trang dau");
			System.out.format(" %-32s ", "0. tro ve");
			 chon = sc.nextInt();
			switch (chon) {
			case 1:
				
					
					
					if(trang+60<dsSV.size())
					{
						trang = trang+30;
					hienThiBangDiem1(dsDiem, dsMh, dsSV,trang);
					
					}
					else
					{
						hienThiBangDiem1(dsDiem, dsMh, dsSV,dsSV.size());
						trang = dsSV.size()-dsSV.size()%30;
					
					}
						
					break;
				
				
					
			
			case 2:
					trang = trang-30;
					hienThiBangDiem1(dsDiem, dsMh, dsSV,trang);
				
				
								break;
			case 3:
				hienThiBangDiem1(dsDiem, dsMh, dsSV,dsSV.size());
				trang = dsSV.size()-dsSV.size()%30;
				
			case 0:
				break;
			case 4:
				trang = 0;
				hienThiBangDiem1(dsDiem, dsMh, dsSV,0);
				
				break;
			
			default:
				if(trang<0)
				System.out.println("chon nhap sai yeu cau");
			
				break;
			}
				

		} while (chon!= 0);
		

		
	}

	private static void hienThiPhanTrangSinhVien( ArrayList<MonHoc> dsMh, ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		int chon;
		
		System.out.println("Chon:");
		Scanner sc = new Scanner(System.in);
		int trang = 0;
		//hienThiBangDiem(dsDiem, dsMh, dsSV, trang);
		SinhVien.hienThiSV(dsSV, 0);
		do {
			
			
			System.out.println();
			
			if(trang<dsSV.size())
			{
			System.out.format(" %-32s", "1. trang sau");
			}
			if(trang>0)
			{
			System.out.format(" %-32s ", "2. trang truoc");
			}
			System.out.format(" %-32s ", "3. trang cuoi");
			System.out.format(" %-32s ", "4. trang dau");
			System.out.format(" %-32s ", "0. tro ve");
			 chon = sc.nextInt();
			switch (chon) {
			case 1:
				
					
					
					if(trang+60<dsSV.size())
					{
						trang = trang+30;
					SinhVien.hienThiSV(dsSV, trang);
					
					}
					else
					{
					
						SinhVien.hienThiSV(dsSV, dsSV.size());
						trang = dsSV.size()-dsSV.size()%30;
						
					}
						
					break;
				
				
					
			
			case 2:
					trang = trang-30;
					
					SinhVien.hienThiSV(dsSV, trang);
					
				
								break;
			case 3:
				SinhVien.hienThiSV(dsSV, dsSV.size());
				trang = dsSV.size()-dsSV.size()%30;
				
			case 0:
				break;
			case 4:
				trang = 0;
				SinhVien.hienThiSV(dsSV, 0);
				
				break;
			
			default:
								System.out.println("chon nhap sai yeu cau");
			
				break;
			}
				

		} while (chon!= 0);
		

		
	}

			
		
		
	

		

		
	

	private static void hienThiBangDiem1(ArrayList<Diem> dsDiem, ArrayList<MonHoc> dsMh, ArrayList<SinhVien> dsSV,int trang) {

		// TODO Auto-generated method stub
		int phantu = 0;
		if(trang < dsSV.size())
		{
			for (int i = trang;i<trang+30;i++) {
				if (SinhVien.checkDiem(dsDiem, dsSV.get(i).getMa()) == true&&phantu <30) {

				
					System.out.println("\n\n┌────────────────────────────────────────────────────────────────┐");
					System.out.format("| %10s %50s  | \n", dsSV.get(i).getMa(), dsSV.get(i).fullName());
					System.out.format("| %10s %50s  | \n", "DTK", SinhVien.dem(dsSV.get(i).getMa(), dsDiem));
					System.out.println("├────────────────────────────────────────────────────────────────┤");
					for (int j = 0; j < DataIO.getDiems(dsSV.get(i).getMa(), dsMh).size(); j++) {
						
						System.out.format("| %10s %25s %25s | \n", dsMh.get(j).getMa(), dsMh.get(j).getTen(),
								dsDiem.get(j).getDiem());
						
					}
					System.out.println("└────────────────────────────────────────────────────────────────┘\n\n");
				
				} else if(SinhVien.checkDiem(dsDiem, dsSV.get(i).getMa()) == false&&phantu <30)
				{
					
					System.out.println("\n\n┌────────────────────────────────────────────────────────────────┐");
					System.out.format("| %10s %50s  | \n", dsSV.get(i).getMa(), dsSV.get(i).fullName());
					System.out.format("| %10s %50s  | \n", "DTK",0 );
					System.out.println("                    MON HOC CHUA CO DIEM               ");
					System.out.println("└────────────────────────────────────────────────────────────────┘\n\n");
					
				}
				phantu++;
			}

		}
		else
		{
			int x = (dsSV.size())%30;
			for (int i =dsSV.size()-x;i<dsSV.size();i++) {
				if (SinhVien.checkDiem(dsDiem, dsSV.get(i).getMa()) == true&&phantu <30) {

				
					System.out.println("\n\n┌────────────────────────────────────────────────────────────────┐");
					System.out.format("| %10s %50s  | \n", dsSV.get(i).getMa(), dsSV.get(i).fullName());
					System.out.format("| %10s %50s  | \n", "DTK", SinhVien.dem(dsSV.get(i).getMa(), dsDiem));
					System.out.println("├────────────────────────────────────────────────────────────────┤");
					for (int j = 0; j < DataIO.getDiems(dsSV.get(i).getMa(), dsMh).size(); j++) {
						
						System.out.format("| %10s %25s %25s | \n", dsMh.get(j).getMa(), dsMh.get(j).getTen(),
								dsDiem.get(j).getDiem());
						
					}
					System.out.println("└────────────────────────────────────────────────────────────────┘\n\n");
				
				} else if(SinhVien.checkDiem(dsDiem, dsSV.get(i).getMa()) == false&&phantu <30)
				{
					
					System.out.println("\n\n┌────────────────────────────────────────────────────────────────┐");
					System.out.format("| %10s %50s  | \n", dsSV.get(i).getMa(), dsSV.get(i).fullName());
					System.out.format("| %10s %50s  | \n", "DTK",0 );
					System.out.println("└────────────────────────────────────────────────────────────────┘\n\n");
					
				}
				phantu++;
			}

		}
				


		

	}



	private static void timKiem(ArrayList<Diem> dsDiem, ArrayList<MonHoc> dsMh, ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		int chon;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\n┌──────────────────────────────────┐");
			System.out.format("│  %18s %12s│\n", " TIM KIEM", "");
			System.out.println("├──────────────────────────────────┤");
			System.out.format("│ %-32s │\n", "1. TIM THEO MA SNH VIEN");
			System.out.format("│ %-32s │\n", "2. TIM THEO TEN SINH VIEN");

			System.out.format("│ %-32s │\n", "0. Tro ve menu truoc");
			System.out.println("└──────────────────────────────────┘\n\n");
			System.out.println("Chon:");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				SinhVien.seachByMaSV(dsDiem, dsMh, dsSV);
				break;
			case 2:
				SinhVien.seachByTen(dsDiem, dsMh, dsSV);
				break;

			default:
				System.out.println("chon nhap sai yeu cau");
				break;
			}

		} while (chon != 0);

	}

	private static void updateListSV(ArrayList<SinhVien> dsSV, ArrayList<MonHoc> dsmh) {
		// TODO Auto-generated method stub
		int chon;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\n┌──────────────────────────────────┐");
			System.out.format("│  %18s %12s│\n", " Cap nhat sinh vien", "");
			System.out.println("├──────────────────────────────────┤");
			System.out.format("│ %-32s │\n", "1. them sinh vien");
			System.out.format("│ %-32s │\n", "2. sua thong tin sinh vien");
			System.out.format("│ %-32s │\n", "3. xoa sinh vien ");
			System.out.format("│ %-32s │\n", "4. Hien Thi Danh Sach SV ");
			System.out.format("│ %-32s │\n", "5. Hien Thi Danh Sach Mon Hoc ");
			System.out.format("│ %-32s │\n", "0. Tro ve menu truoc");
			System.out.println("└──────────────────────────────────┘\n\n");
			System.out.println("Chon:");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				SinhVien.addsv(dsSV);
				break;
			case 2:
				SinhVien.suaSV(dsSV);
				break;
			case 3:
				SinhVien.xoaSV(dsSV);
				break;
			case 4:
				
				hienThiPhanTrangSinhVien(dsmh, dsSV);
				break;
			case 5:
				MonHoc.hienThiMH(dsmh);
				break;
			case 0:
				break;
			default:
				System.out.println("chon nhap sai yeu cau");
				break;
			}

		} while (chon != 0);

	}

	private static void printMenu1() {
		// TODO Auto-generated method stub

		System.out.println("\n\n┌────────────────────────────────┐");
		System.out.format("│  %15s %14s│\n", new Object[] { " MENU", "" });
		System.out.println("├────────────────────────────────┤");
		System.out.format("│ %-30s │\n", new Object[] { "1. Cap nhat danh sach" });
		System.out.format("│ %-30s │\n", new Object[] { "2. Hien thi bang diem" });
		System.out.format("│ %-30s │\n", new Object[] { "3. Tim kiem" });
		System.out.format("│ %-30s │\n", new Object[] { "0. Thoat va luu" });
		System.out.println("└────────────────────────────────┘\n\n");
	}
	private static void Menu2()
	{
		
	}

}
