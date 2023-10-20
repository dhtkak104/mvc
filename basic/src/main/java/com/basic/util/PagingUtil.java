package com.basic.util;

public class PagingUtil {

	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	private static final int NUM_OF_NAVI_PAGE = 5;

	/*	pageNo to query startRowrum 
	 * 	
	 * 	(pageNo * pageSize) - (pageSize -1);
	 * 	(1*10) - (10-1) = 1
	 *  (2*10) - (10-1) = 11
	 *  (3*10) - (10-1) = 21
	 */
	public static int selectStartRowrum(int pageNo){
		return selectOffset(pageNo, NUM_OF_MESSAGE_PER_PAGE);
    }
	
	public static int selectStartRowrum(int pageNo, int pageSize){
		return (pageNo * pageSize) - (pageSize -1);
    }
	
	/*	pageNo to query endRowrum 
	 * 	
	 * 	pageNo * pageSize;
	 * 	1*10 = 10
	 *  2*10 = 20
	 *  3*10 = 30 
	 */
	public static int selectEndRowrum(int pageNo){
		return selectOffset(pageNo, NUM_OF_MESSAGE_PER_PAGE);
    }
	
	public static int selectEndRowrum(int pageNo, int pageSize){
		return pageNo * pageSize;
    }
	
	/*	pageNo to offset 
	 * 	
	 * 	pageSize * (pageNo -1);
	 * 	10 * (1-1) = 0
	 *  10 * (2-1) = 10
	 *  10 * (3-1) = 20 
	 */
	public static int selectOffset(int pageNo){
		return selectOffset(pageNo, NUM_OF_MESSAGE_PER_PAGE);
    }
	
	public static int selectOffset(int pageNo, int pageSize){
		return pageSize * (pageNo -1);
    }
	
	/*	select page navigation bar startPage
	 * 	
	 * 	((currentPage-1)/naviPage)*naviPage + 1;
	 * 	((1-1)/5)*5+1 = 1 
	 *  ((2-1)/5)*5+1 = 1
	 *  ...
	 *  ((5-1)/5)*5+1 = 1
	 *  ((6-1)/5)*5+1 = 2
	 */
	public static int selectStartPage(int currentPage) {
		return selectStartPage(currentPage, NUM_OF_NAVI_PAGE);
	}
	
	public static int selectStartPage(int currentPage, int naviPage) {
		return ((currentPage-1)/naviPage)*naviPage + 1;
	}
	
	/*	select page navigation bar endPage
	 * 	
	 * 	(((currentPage-1)/naviPage)+1)*naviPage;
	 * 	(((1-1)/5)+1)*5 = 5 
	 *  (((2-1)/5)+1)*5 = 5
	 *  ...
	 *  (((5-1)/5)+1)*5 = 5
	 *  (((6-1)/5)+1)*5 = 10
	 */
	public static int selectEndPage(int currentPage) {
		return selectEndPage(currentPage, NUM_OF_NAVI_PAGE);
	}
	
	public static int selectEndPage(int currentPage, int naviPage) {
		return (((currentPage-1)/naviPage)+1)*naviPage;
	}
	
	/*	select page navigation bar pageCnt
	 * 	
	 * 	(int)Math.ceil(((double)totalCnt / perPage));
	 * 	cf. Math.ceil : 인자보다 같거나 큰 정수 반환. Math.ceil(3.14) => 4 
	 *  
	 *  (int)Math.ceil(((double)100 / 10)) = 10  
	 * 	(int)Math.ceil(((double)101 / 10)) = 11
	 * 	(int)Math.ceil(((double)102 / 10)) = 11  
	 *  ...
	 *  (int)Math.ceil(((double)110 / 10)) = 11
	 *  (int)Math.ceil(((double)111 / 10)) = 12
	 */
	public static int selectPageTotalCnt(long totalCnt) {
		return selectPageTotalCnt(totalCnt, NUM_OF_MESSAGE_PER_PAGE);
	}
	
	public static int selectPageTotalCnt(long totalCnt, int perPage) {
		int pageTotalCount = 0;
		if(totalCnt != 0) {
			pageTotalCount = (int)Math.ceil(((double)totalCnt / perPage));
		}
		return pageTotalCount;
	}
}
