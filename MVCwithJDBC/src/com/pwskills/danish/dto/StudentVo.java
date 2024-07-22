package com.pwskills.danish.dto;

public class StudentVo {
		@Override
	public String toString() {
		return "StudentVo [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
		private String sid;
		private String sname;
		private String sage;
		private String saddress;
		
		
		public StudentVo(){
			System.out.println("StudentVo object created");
		}

		
		public String getSid() {
			return sid;
		}

		public void setSid(String sid) {
			this.sid = sid;
		}

		public String getSname() {
			return sname;
		}
		public String getSage() {
			return sage;
		}
		public String getSaddress() {
			return saddress;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public void setSage(String sage) {
			this.sage = sage;
		}
		public void setSaddress(String saddress) {
			this.saddress = saddress;
		}
		
		
		
		
}
