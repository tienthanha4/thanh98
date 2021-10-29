import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;




public class SinhVien implements Data {

	private String ma,hoDem,ten,ngaySinh,gioiTinh;
	private static int currentCode = 0;
	
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String hoDem, String ten, String ngaySinh, String gioiTinh) {
		super();
		String code = String.format("%05d", new Object[] { Integer.valueOf(currentCode + 1) });
		this.ma = "SV"+code; currentCode++;
		
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		
	}
	public SinhVien(String ma, String hoDem, String ten, String ngaySinh, String gioiTinh) {
		super();
		this.ma = ma;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		updateCurr(ma);
	}

	private void updateCurr(String ma) {
		String numb = ma.replace("SV", "");
		try {
				int n = Integer.parseInt(numb);
				if (n > currentCode) currentCode = n; 
		     } 
		catch (NumberFormatException numberFormatException) {}
	}

	public String getMa() {
		return ma;
	}

	@Override
	public String toString() {
		return "SinhVien [ma=" + ma + ", hoDem=" + hoDem + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + "]";
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	public String fullName()
	{
		return hoDem+" "+ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public static void addsv(ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("NHAP HO SINH VIEN ");
		String hoDem = sc.next();
		System.out.println("NHAP TEN : ");
		String ten  = sc.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("NHAP NGAY SINH");
		String ngay = sc.next();
		System.out.println("NHAP thang sinh ");
		String thang = sc.next();
		System.out.println("nhap nam sinh  ");
		String nam = sc.next();
        String dateInString = ngay+"/"+thang+"/"+nam;
        
        try {
            Date date = formatter.parse(dateInString);
           // System.out.println(date);
           // System.out.println(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("loi~");
        }
        System.out.println("NHAP GIOI TINH ");
        String gioiTinh = sc.next();
        SinhVien sv = new SinhVien(hoDem, ten, dateInString, gioiTinh);
        dsSV.add(sv);
        System.out.println("them thanh cong ");
        sv.showInfo();
		
		
		
		
		
	}

	public static void suaSV(ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma sinh vien muon sua :");
		String ma = sc.next();
		int vt=0;
		int dem = 0;
		for(int i = 0;i<dsSV.size();i++)
		{
			if(dsSV.get(i).getMa().equals(ma))
			{
				vt = i;
				dem++;
				
			}
		}
		if(dem == 0)
		{
			System.out.println("khong tim ra sinh vien can sua" );
		}
		else 
		{
			dsSV.get(vt).showInfo();
			System.out.println("\nNhap lai thong tin sinh vien theo dang");
			System.out.println("sua thong tin ho dem : "+dsSV.get(vt).getHoDem()+"->");
			String hoDem = sc.next();
			System.out.println("sua ten "+dsSV.get(vt).getTen()+"->");
			String ten  = sc.next();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("NHAP NGAY SINH");
			String ngay = sc.next();
			System.out.println("NHAP thang sinh ");
			String thang = sc.next();
			System.out.println("nhap nam sinh  ");
			String nam = sc.next();
	        String dateInString = ngay+"/"+thang+"/"+nam;
	        System.out.println("NHAP GIOI TINH ");
	        String gioiTinh = sc.next();
	        try {
	            Date date = formatter.parse(dateInString);
	           // System.out.println(date);
	           // System.out.println(formatter.format(date));
	        } catch (ParseException e) {
	            //e.printStackTrace();
	            System.out.println("YEU CAU NHAP NGAY SINH BANG SO");
	            dateInString = dsSV.get(vt).getNgaySinh();
	        }
	        
	        
	        if(hoDem.isEmpty())
	        {
	        	hoDem = dsSV.get(vt).getHoDem();
	        }
	        else if(ten.isEmpty())
	        {
	        	ten = dsSV.get(vt).getTen();
	        }
	        else if(ngay.isEmpty()||thang.isEmpty()||nam.isEmpty())
	        {
	        	dateInString = dsSV.get(vt).getNgaySinh();
	        }
	        else if(!gioiTinh.equals("nam")||!gioiTinh.equals("nu"))
	        {
	        	gioiTinh = dsSV.get(vt).gioiTinh;
	        	System.out.println("NHAP GIOI TINH SAI ");
	        }
	      
	        SinhVien sv = new SinhVien(dsSV.get(vt).getMa(),hoDem, ten, dateInString, gioiTinh);
	        dsSV.set(vt,sv);
	        System.out.println("sua thanh cong ");
	        
	        System.out.println("\n\n------------------------------------------------------------------");
			System.out.format("| %10s | %10s | %10s  | %10s | %10s  | \n", dsSV.get(vt).getMa(),hoDem, ten, dateInString, gioiTinh);
			System.out.println("------------------------------------------------------------------\n\n");
			
		}
		
		
	}

	public static void xoaSV(ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma sinh vien muon xoa :");
		String ma = sc.next();
		if(checkDiem(DataIO.dsDiem, ma)==false)
		{
			for(int i = 0;i<dsSV.size();i++)
			{
				
					if(dsSV.get(i).getMa().equals(ma))
					{
						dsSV.remove(i);
						System.out.println("xoa thanh cong ");
						
					}
					
					
					
					
				}
				
			}
		else {
			System.out.println("khong xoa duoc vi sinh vien da co diem");
		}
}
	
	
		
		
		
		
	    
		
		
	
	public static Boolean checkDiem(ArrayList<Diem> diem,String maSV)
	{
		for (Diem d : DataIO.dsDiem)
		{
			if(maSV.equals(d.getMaSinhvien()))
				return true;
			
		}
		return false;
	}
	
	public void showInfo() {
		    String out = String.format("[%8s  %s %s  %s  %s]", new Object[] { this.ma, getHoDem(), getTen(), this.ngaySinh, getGioiTinh() });
		    System.out.println(out);
   }

	public static void hienThiSV(ArrayList<SinhVien> dsSV,int trang) {
		Comparator<SinhVien> com = new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				if(o1.ten.compareTo(o2.ten)==0)
				{
					return (o1.hoDem.compareTo(o2.hoDem));
				}
				
				return  (o1.ten.compareTo(o2.ten));
			}
		};
		// TODO Auto-generated method stub
		dsSV.sort(com);
		System.out.println(dsSV.size());
		if( trang < dsSV.size())
		{
			System.out.format("%1s %50s %50s %50s \n","MA SINH VIEN","TEN SINH VIEN","NGAY SINH","GIOI TINH");
			for (int i = trang; i < trang+30; i++) {
				
				System.out.format("%1s %50s %50s %50s \n",dsSV.get(i).getMa(),dsSV.get(i).fullName(),dsSV.get(i).getNgaySinh(),dsSV.get(i).getGioiTinh());
			}
		}
		else
		{
			int x = dsSV.size()%30;
			System.out.format("%1s %50s %50s %50s \n","MA SINH VIEN","TEN SINH VIEN","NGAY SINH","GIOI TINH");
			for (int i = dsSV.size()-x; i < dsSV.size(); i++) {
				
				System.out.format("%1s %50s %50s %50s \n",dsSV.get(i).getMa(),dsSV.get(i).fullName(),dsSV.get(i).getNgaySinh(),dsSV.get(i).getGioiTinh());
			}
		}
		
		
		
	}
	

	public static void seachByMaSV(ArrayList<Diem> dsDiem, ArrayList<MonHoc> dsMh, ArrayList<SinhVien> dsSV) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma sinh vien muon tim :");
		String ma = sc.next();
		int dem = 0;
			for (SinhVien sinhVien : dsSV) {
				if(sinhVien.getMa().equals(ma)&& checkDiem(dsDiem, ma)== true)
				{
					
					
						
						
						System.out.format("%1s %50s \n",sinhVien.getMa(),sinhVien.fullName());
						System.out.format("%1s %50s \n","DTK",dem(ma,dsDiem));
						
						for(int i = 0;i<DataIO.getDiems(sinhVien.getMa(), dsMh).size();i++)
						{
							
							System.out.format("%1s %25s %25s \n",dsMh.get(i).getMa(),dsMh.get(i).getTen(),dsDiem.get(i).getDiem());
							float diem  = Float.valueOf(dsDiem.get(i).getDiem());
							float heso = Float.valueOf(dsMh.get(i).getHeSo());
							 
							
						}
						dem++;
						
					}
				else if(sinhVien.getMa().equals(ma)&& checkDiem(dsDiem, ma)== false)
				{
					System.out.format("%1s %50s \n",sinhVien.getMa(),sinhVien.fullName());
					System.out.println("khong co diem");
					dem++;
				}
				
				
					
				
					
				}
			if(dem == 0)
			{
				System.out.println("khong co sinh vien do ");
			}
			
				
				
				
				
			}
				
			
			
				
					
				
			
		
		
	

	public static void seachByTen(ArrayList<Diem> dsDiem, ArrayList<MonHoc> dsMh, ArrayList<SinhVien> dsSV) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ten sinh vien muon tim :");
		String ten = sc.next().toLowerCase();
		int dem = 0;
			for (SinhVien sinhVien : dsSV) {
				
				if(sinhVien.getTen().toLowerCase().equals(ten) &&checkDiem(dsDiem,getMaSV(sinhVien.getMa())) == true  )
				{
					//
					
						System.out.println("-----------------------------------------------------");	
						System.out.format("%1s %15s %5s %30s \n",sinhVien.getMa(),sinhVien.getNgaySinh(),sinhVien.getGioiTinh(),sinhVien.fullName());
						System.out.format("%1s %50s \n","DTK",dem(SinhVien.getMaSV(sinhVien.getTen()), dsDiem));
						
						for(int i = 0;i<DataIO.getDiems(sinhVien.getMa(), dsMh).size();i++)
						{
							
							System.out.format("%1s %25s %25s \n",dsMh.get(i).getMa(),dsMh.get(i).getTen(),dsDiem.get(i).getDiem());
							
							
							
						dem++;	
						}
						
						
					}
				else if(sinhVien.getTen().toLowerCase().equals(ten) &&checkDiem(dsDiem,getMaSV(sinhVien.getMa())) == false )
				{	
					System.out.println("---------------------------------------------------------------------------");
					System.out.format("%1s %50s \n",sinhVien.getMa(),sinhVien.fullName());
					System.out.format("%1s %50s \n","DTK : ",0);
					System.out.println("khong co diem");
					dem++;
				}
				
				
				
			}
			if(dem ==0)
			{
				System.out.println("khong co ten sinh vien do");
			}
		
	}
	
	public static String getTenMh(String maMh) {
		    for (MonHoc m : DataIO.dsMonHoc) {
		       if (m.getMa().equals(maMh)) return m.getTen(); 
		     } 
		     return "";
		   }

	public static String getTenSV(String ten) {
	    for (SinhVien sv : DataIO.dsSinhVien) {
	       if (sv.getTen().toLowerCase().equals(ten.toLowerCase())) return sv.getTen(); 
	     } 
	    return "";
	   }
	public static String getMaSV(String ten) {
	    for (SinhVien sv : DataIO.dsSinhVien) {
	       if (sv.getTen().toLowerCase().equals(ten.toLowerCase())) return sv.getMa(); 
	     } 
	    return ten;
	   }
	public static float getHeso(String maMh) {
     for (MonHoc m : DataIO.dsMonHoc) {
       if (m.getMa().equals(maMh)) return m.getHeSo(); 
     } 
    return 0.0F;
   }
	public static float dem(String maSV,ArrayList<Diem> dsDiem)
	{
		float diem = 0;
		float tongHeSo = 0;

		for (Diem d : dsDiem) {
			if(d.getMaSinhvien().equals(maSV)&&checkDiem(dsDiem, maSV)== true)
			{
				float diemt = Float.parseFloat(d.getDiem());
				float hoSoT = Float.valueOf(SinhVien.getHeso(d.getMaMon()));
				float tong = diemt*hoSoT;
				tongHeSo = tongHeSo + hoSoT;
				 diem  = diem +tong;
				
				
				
					
			}
			else if(checkDiem(dsDiem, maSV)== false)
			{
				return 0;
			}
			
		}
		
		return (float) diem/(tongHeSo);
		
	}

	@Override
	public String getLine() {
		// TODO Auto-generated method stub
		String line = String.valueOf(this.ma) + ";" + this.hoDem + ";" + this.ten + ";" + this.ngaySinh + ";" + this.gioiTinh;
		/* 72 */     return line;
	
	}
	
	
}
