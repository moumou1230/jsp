package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage, endPage;
	private boolean prev, next;
	private int page;
	
	// 생성자
	public PageDTO(int page, int totalCnt) {
		this.page = page; // 현재 4페이지면(1page ~ 4page ~ 10page), 14페이지면( 11page ~ 14page ~ 20page)
		this.endPage = (int)(Math.ceil(page/10.0) * 10);
		this.startPage = this.endPage - 9;
		
		int realEnd =  (int)Math.ceil(totalCnt/5.0);
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage == realEnd ? false : true;
	}
}
