package co.yedam.vo;

import java.util.Date;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data //getter setter tostring �븳踰덉뿉 �떎�맖.
public class Student {
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;
	
}
