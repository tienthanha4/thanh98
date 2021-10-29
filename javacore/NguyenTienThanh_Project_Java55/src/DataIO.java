import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;


public class DataIO {
	static File _monhoc = null;
	   static File _sinhvien = null;
	   static File _diem = null;
	   public static boolean engMode = false;
	private static String name_mh = "monhoc.txt"; private static String name_sv = "sinhvien.txt"; private static String name_diem = "diem.txt";
	   public static String dataDir = "";
	public static ArrayList<SinhVien> dsSinhVien  = new ArrayList<SinhVien>();
	public static ArrayList<Diem> dsDiem = new ArrayList<Diem>();
	public static ArrayList<MonHoc> dsMonHoc = new ArrayList<MonHoc>();
	public static String dataRoot = "";
	public static String fileSinhVien = "sinhvien.txt";
	public static String fileDiem = "diem.txt";
	public static String fileMonHoc = "monhoc.txt";
	public static void loadData() throws IOException
	{
		_monhoc = new File(String.valueOf(dataRoot) + "\\" + name_mh);
		     _sinhvien = new File(String.valueOf(dataRoot) + "\\" + name_sv);
		     _diem = new File(String.valueOf(dataRoot) + "\\" + name_diem);
		
		loadSinhVien();
		loadMonHoc();
		loadDiem();
	}
	
	
	public static MonHoc getMaMonHoc(String maMH)
	{
		for (int i = 0; i < dsMonHoc.size(); i++) {
			if(dsMonHoc.get(i).getMa().equals(maMH))
				return dsMonHoc.get(i);
				
		}
		return null;
		
	}
	public static ArrayList<Diem> getDiems(String maSV,ArrayList<MonHoc>dsMonHoc)
	{
		ArrayList<Diem> list = new ArrayList<Diem>();
		for (int i = 0; i < dsMonHoc.size(); i++) {
			String maMH = dsMonHoc.get(i).getMa();
			for (int j = 0; j < dsDiem.size(); j++) {
				Diem d = dsDiem.get(j);
				if(d.getMaSinhvien().equals(maSV)&&d.getMaMon().equals(maMH))
				{
					list.add(d);
				}
			}
		}
		return list;
	}
	
	private static void loadSinhVien() throws IOException
	{
		FileReader freader = null;
		BufferedReader buffer = null;
		File file = new File(dataRoot+"/"+fileSinhVien);
		try {
			freader = new FileReader(file);
			buffer = new BufferedReader(freader);
			String line;
			while((line = buffer.readLine()) != null )
					{
						if(line.startsWith("#"))
							continue;
						String parts[] = line.split(";");
						String ma = parts[0]; 
						String hoDem = parts[1]; 
						String ten = parts[2]; 
						String ngaySinh = parts[3]; 
						String gioiTinh = parts[4]; 
						SinhVien s = new SinhVien(ma,hoDem,ten,ngaySinh,gioiTinh);
						dsSinhVien.add(s);
					}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				if(buffer != null) buffer.close();
				if(freader != null) freader.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
		private static void loadMonHoc() throws IOException
		{
			FileReader freader = null;
			BufferedReader buffer = null;
			File file = new File(dataRoot+"/"+fileMonHoc);
			try {
				freader = new FileReader(file);
				buffer = new BufferedReader(freader);
				String line;
				while((line = buffer.readLine()) != null )
						{
							if(line.startsWith("#"))
								continue;
							String parts[] = line.split(";");
							String maMonHoc = parts[0]; 
							String tenMonHoc = parts[1]; 
							String heSo = parts[2]; 
							
							MonHoc mh = new MonHoc(maMonHoc, tenMonHoc, Float.parseFloat(heSo));
							dsMonHoc.add(mh);
						}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					if(buffer != null) buffer.close();
					if(freader != null) freader.close();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
		private static void loadDiem() throws IOException
		{
			FileReader freader = null;
			BufferedReader buffer = null;
			File file = new File(dataRoot+"/"+fileDiem);
			try {
				freader = new FileReader(file);
				buffer = new BufferedReader(freader);
				String line;
				while((line = buffer.readLine()) != null )
						{
							if(line.startsWith("#"))
								continue;
							String parts[] = line.split(";");
							String maSV = parts[0]; 
							String maMonHoc = parts[1]; 
							String diem = parts[2]; 
							
							Diem d = new Diem(maSV, maMonHoc, diem);
							dsDiem.add(d);
						}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					if(buffer != null) buffer.close();
					if(freader != null) freader.close();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
		private static <T> void saveData(File file, ArrayList<T> ls) {
			     FileWriter fw = null;
			     BufferedWriter bufW = null;
			     ArrayList<Data> list = (ArrayList)ls;
			     try {
			       fw = new FileWriter(file);
			       bufW = new BufferedWriter(fw);
			       bufW.write((list.get(0).getColumns()));
			       bufW.newLine();
			       for (Data data : list) {
			         bufW.write(data.getLine());
			         bufW.newLine();
			       } 
			     } catch (IOException e) {
			       e.printStackTrace();
			     } finally {
			       try {
			         if (bufW != null) bufW.close(); 
			       } catch (Exception e) {
			         e.printStackTrace();
			      } 
			     } 
			   }
			 
			   
			   public static void setEngMode(boolean mode) {
			     engMode = mode;
			     name_mh = "monhoc_en.txt";
			     name_sv = "sinhvien_en.txt";
			   }
			 
			   
			   public static void saveAllData(ArrayList<SinhVien> ls1, ArrayList<MonHoc> ls2, ArrayList<Diem> ls3) {
			     saveSinhVien();
			     //saveDiem();
			     //saveMonHoc();
			   }
			   
			   private static void saveSinhVien() {
			     saveData(_sinhvien, dsSinhVien);
			   }
			   
			   private static void saveDiem() {
			     saveData(_diem, dsDiem);
			   }
			   
			   private static void saveMonHoc() {
			     saveData(_monhoc, dsMonHoc);
			   }
			 
			   
			   public static void setDataDir(String s) {
			     dataDir = s;
			   }
			 }
		

		


