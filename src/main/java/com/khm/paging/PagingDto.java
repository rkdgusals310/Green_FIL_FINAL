package com.khm.paging;

import java.util.List;



import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PagingDto {

	private int listtotal;		//1. 전체글
	private int onepagelimit;	//2. 한페이지에 보여줄 게시물의 수
	private int pagetotal;		//3. 총페이지 계산	전체글/ 한페이지에 보여줄 게시물의 수
	private int bottomlimit;	//4. 하단에 페이지 나누기 수
	private int pstartno;		//5. 페이지의 스타트 번호
	private int current ;		//6. 하단 현재번호
	private int start ;			//7. 하단 시작
	private int end ;			//8. 하단 끝
	



	
	//private List<Object> list; -선택사항

	public PagingDto(int listtotal, int pstartno) {
		super();
		this.listtotal = listtotal;	// 전체글
		this.onepagelimit = 10;	// 한페이지에 보여줄 게시물의 수

		this.pagetotal = (int)Math.ceil((double)listtotal/onepagelimit);	
		this.bottomlimit = 10;
		this.pstartno = pstartno;
		this.current=(int)Math.ceil((pstartno+1)/(double)onepagelimit);
		this.start = ((int)Math.floor((this.current-1)/(double)bottomlimit))*bottomlimit+1;
		this.end = this.start+this.bottomlimit-1;
		
		if(pagetotal<end) {this.end=pagetotal;}
		
	}	
	
	
}
