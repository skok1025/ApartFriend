package com.twoplus.apartfriend.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ?��?��징을 ?��?�� ?��?��
 * @author �??��?��
 *
 */
public class PagingFrontUtil {

	/**
	 * ?��?���? �??���? �?�? 맵을 반환?��?�� 메소?��
	 * @param currentPage ?��?��?��?���?
	 * @param totalcount ?���? 게시�? ?�� 
	 * @param pageSize ?�� ?��?���??�� 게시�? ?�� 
	 * @param listSize ?��?���? 리스?�� ?��   ex)  < 1 2 3 4 5 >  ?��?���? listSize = 5
	 * @return ?��?���? �??���? ?��?? Map
	 *         currentPage = ?��?�� ?��?���?
	 *         endPage = 마�?�? ?��?���?
	 *         prevPage = ?��?�� ?��?���? 리스?��?�� ?��?�� ?��?���? (?��?�� ?��?���? 리스?��?�� 마�?�? ?��?���?)
	 *         nextPage = ?��?�� ?��?���? 리스?��?�� ?��?�� ?��?���? (?��?�� ?��?���? 리스?��?�� 첫번�? ?��?���?)
	 *         nowStart = ?��?�� ?��?���? 리스?��?�� ?��?�� ?��?���?
	 *         nowEnd = ?��?�� ?��?���? 리스?��?�� 마�?�? ?��?���? 
	 * @author �??��?��
	 */
	public static Map<String, Integer> 
	getPagingVariable
	(Integer currentPage,Integer totalcount,Integer pageSize,Integer listSize){
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		Integer pageCount = (int) Math.ceil((double)totalcount/pageSize);
		
		if(currentPage > pageCount) {
			currentPage = pageCount;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}
		
		Integer listNum = (int)Math.ceil((double)currentPage/ listSize); // ?��?���? 리스?��?�� ?��?��?��
		Integer nextPage = 1 + listSize * listNum; // ?��?�� ?��?���? 리스?��?�� ?��?�� ?��?���? (?��?�� ?��?���? 리스?��?�� 첫번�? ?��?���?)
		Integer prevPage = listNum== 1 ? 1 : nextPage - listSize - 1; // ?��?�� ?��?���? 리스?��?�� ?��?�� ?��?���? (?��?�� ?��?���? 리스?��?�� 마�?�? ?��?���?)
		Integer endPage = (int)Math.ceil((double)totalcount / pageSize); // 마�?�? ?��?���?
		
		// ?��?�� ?��?���??�� 리스?�� ?��?���? ?��
		Integer nowStart = listNum*listSize-(listSize-1);
		Integer nowEnd = listNum*listSize;
		
		result.put("currentPage", currentPage);
		result.put("endPage", endPage);
		result.put("prevPage", prevPage);
		result.put("nextPage", nextPage);
		
		result.put("nowStart", nowStart);
		result.put("nowEnd", nowEnd);
		
		
		
		return result;
		
	}
	
	
	/**
	 * �?�?�? ?�� 게시�? ?��?�� ?��?��?���? 반환?��?�� 메소?��
	 * @param currentPage ?��?�� ?��?���?
	 * @param totalCount ?���? 게시�? ?�� 
	 * @param pageSize ?�� ?��?���??�� 게시�? ?�� 
	 * @return �?�?�? ?�� 게시�? ?��?�� ?��?��?��
	 */
	public static Integer getStartRecordNum
	(Integer currentPage,
	Integer totalCount,		
	Integer pageSize
	) {
		Integer pageCount = (int) Math.ceil((double)totalCount/pageSize);
		
		if(currentPage > pageCount) {
			currentPage = pageCount;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}
		
		return (currentPage- 1) * pageSize;
	}
	
}
