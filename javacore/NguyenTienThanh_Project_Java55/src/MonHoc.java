import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class MonHoc  implements Data{
	private String ma,ten;
	private float heSo;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public float getHeSo() {
		return heSo;
	}
	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}
	public MonHoc(String ma, String ten, float heSo) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.heSo = heSo;
	}
	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void hienThiMH(ArrayList<MonHoc> dsmh) {
		// TODO Auto-generated method stub
		Comparator<MonHoc> com = new Comparator<MonHoc>() {

			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				// TODO Auto-generated method stub
				
				return  (o1.ten.compareTo(o2.ten));
			}
		};
		// TODO Auto-generated method stub
		dsmh.sort(com );
		System.out.format("%10s %50s %50s \n","MA MON HOC","TEN MON HOC","HE SO");
		for (int i = 0; i < dsmh.size(); i++) {
			System.out.format("%10s %50s %50s \n",dsmh.get(i).getMa(),dsmh.get(i).ten,dsmh.get(i).heSo);
		}
		
	}
	@Override
	public String getLine() {
		Locale us = Locale.US;
		/* 92 */     String out = String.format(us, "%03s;%s;%s", new Object[] { this.ma,this.getTen(),this.getHeSo() });
		/* 93 */     return out;
	}
	
}
