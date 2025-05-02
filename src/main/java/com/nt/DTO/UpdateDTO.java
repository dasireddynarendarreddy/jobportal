package com.nt.DTO;

public class UpdateDTO {
	private String id;
	private String status;
	private String student_id;
	/*
	id
: 
"681319d764f9197e98d3145c"
student_id
: 
"681208c00982447331e5cf36"
student_mailid
: 
"pavan@gmail.com"*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	@Override
	public String toString() {
		return "UpdateDTO [id=" + id + ", status=" + status + ", student_id=" + student_id + "]";
	}

}
