package com.pwskills.danish.dto;

public class StudentBo {
		private Integer sid;
		private String sname;
		private Integer sage;
		private String saddress;
		private String status;
		
		
		public StudentBo(){
			System.out.println("StudentBo object created");
		}


		@Override
		public String toString() {
			return "StudentBo [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress
					+ ", status=" + status + "]";
		}


		public Integer getSid() {
			return sid;
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


		public String getStatus() {
			return status;
		}


		public void setSid(Integer sid) {
			this.sid = sid;
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


		public void setStatus(String status) {
			this.status = status;
		}

		
		
		
		
		
		
		
}
