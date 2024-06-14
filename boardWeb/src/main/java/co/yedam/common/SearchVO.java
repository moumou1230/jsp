	package co.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//검색 조건을 담는 클래스
@Data
@AllArgsConstructor //변수 다 채워주는 생성자를 만들어줌
@NoArgsConstructor //allargs 때문에 기본생성자 없어져서 기본생성자 만들어주기 위해
public class SearchVO {
	private int page;
	private String searchCondition;
	private String keyword;
}
