package com.twoplus.apartfriend.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ??΄μ§μ ?? ? ?Έ
 * @author κΉ???
 *
 */
public class PagingFrontUtil {

	/**
	 * ??΄μ§? λ³??λ₯? κ°?μ§? λ§΅μ λ°ν?? λ©μ?
	 * @param currentPage ??¬??΄μ§?
	 * @param totalcount ? μ²? κ²μλ¬? ? 
	 * @param pageSize ? ??΄μ§?? κ²μλ¬? ? 
	 * @param listSize ??΄μ§? λ¦¬μ€?Έ ?   ex)  < 1 2 3 4 5 >  ?΄?Όλ©? listSize = 5
	 * @return ??΄μ§? λ³??λ₯? ?΄?? Map
	 *         currentPage = ??¬ ??΄μ§?
	 *         endPage = λ§μ?λ§? ??΄μ§?
	 *         prevPage = ??¬ ??΄μ§? λ¦¬μ€?Έ? ?΄?  ??΄μ§? (?΄?  ??΄μ§? λ¦¬μ€?Έ? λ§μ?λ§? ??΄μ§?)
	 *         nextPage = ??¬ ??΄μ§? λ¦¬μ€?Έ? ?€? ??΄μ§? (?€? ??΄μ§? λ¦¬μ€?Έ? μ²«λ²μ¨? ??΄μ§?)
	 *         nowStart = ??¬ ??΄μ§? λ¦¬μ€?Έ? ?? ??΄μ§?
	 *         nowEnd = ??¬ ??΄μ§? λ¦¬μ€?Έ? λ§μ?λ§? ??΄μ§? 
	 * @author κΉ???
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
		
		Integer listNum = (int)Math.ceil((double)currentPage/ listSize); // ??΄μ§? λ¦¬μ€?Έ? ?Έ?±?€
		Integer nextPage = 1 + listSize * listNum; // ??¬ ??΄μ§? λ¦¬μ€?Έ? ?€? ??΄μ§? (?€? ??΄μ§? λ¦¬μ€?Έ? μ²«λ²μ¨? ??΄μ§?)
		Integer prevPage = listNum== 1 ? 1 : nextPage - listSize - 1; // ??¬ ??΄μ§? λ¦¬μ€?Έ? ?΄?  ??΄μ§? (?΄?  ??΄μ§? λ¦¬μ€?Έ? λ§μ?λ§? ??΄μ§?)
		Integer endPage = (int)Math.ceil((double)totalcount / pageSize); // λ§μ?λ§? ??΄μ§?
		
		// ??¬ ??΄μ§?? λ¦¬μ€?Έ ??κ³? ?
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
	 * κ°?μ§?κ³? ?¬ κ²μλ¬? ?? ?Έ?±?€λ₯? λ°ν?? λ©μ?
	 * @param currentPage ??¬ ??΄μ§?
	 * @param totalCount ? μ²? κ²μλ¬? ? 
	 * @param pageSize ? ??΄μ§?? κ²μλ¬? ? 
	 * @return κ°?μ§?κ³? ?¬ κ²μλ¬? ?? ?Έ?±?€
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
