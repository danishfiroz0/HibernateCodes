package com.pwskills.danish.dto;

public class StudentDto {
		private Integer sid;
		private String sname;
		private Integer sage;
		private String saddress;
		
		
		
		
		public StudentDto(){
			System.out.println("StudentDto object created");
		}

		
		
		
		@Override
		public String toString() {
			return "StudentDto [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
		}

		
		
		public Integer getSid() {
			return sid;
		}
		public void setSid(Integer sid) {
			this.sid = sid;
		}

		public String getSname() {
			return sname;
		}

		public Integer getSage() {
			return sage;
		}

		public String getSaddress() {
			return saddress;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public void setSage(Integer sage) {
			this.sage = sage;
		}

		public void setSaddress(String saddress) {
			this.saddress = saddress;
		}
		
		
		
		
}
