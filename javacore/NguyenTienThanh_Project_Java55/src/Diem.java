
public class Diem implements Data {
	private String maSinhvien,maMon,diem;

	public Diem(String maSinhvien, String maMon, String diem) {
		super();
		this.maSinhvien = maSinhvien;
		this.maMon = maMon;
		this.diem = diem;
	}

	public Diem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getMaSinhvien() {
		return maSinhvien;
	}

	public void setMaSinhvien(String maSinhvien) {
		this.maSinhvien = maSinhvien;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "Diem [maSinhvien=" + maSinhvien + ", maMon=" + maMon + ", diem=" + diem + "]";
	}
	public String getColumns() {
		/* 62 */     return "# ma sinh vien; ma mon hoc; diem";
		/*    */   }

	@Override
	public String getLine() {
		String out = String.format("%s;%s;%s", new Object[] { this.maSinhvien, this.maMon, this.diem });
		    return out;
	}
	
	

}
