package com.twoplus.apartfriend.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ?˜?´ì§•ì„ ?œ„?•œ ?œ ?‹¸
 * @author ê¹??„?˜„
 *
 */
public class PagingFrontUtil {

	/**
	 * ?˜?´ì§? ë³??ˆ˜ë¥? ê°?ì§? ë§µì„ ë°˜í™˜?•˜?Š” ë©”ì†Œ?“œ
	 * @param currentPage ?˜„?¬?˜?´ì§?
	 * @param totalcount ? „ì²? ê²Œì‹œë¬? ?ˆ˜ 
	 * @param pageSize ?•œ ?˜?´ì§??˜ ê²Œì‹œë¬? ?ˆ˜ 
	 * @param listSize ?˜?´ì§? ë¦¬ìŠ¤?Š¸ ?ˆ˜   ex)  < 1 2 3 4 5 >  ?´?¼ë©? listSize = 5
	 * @return ?˜?´ì§? ë³??ˆ˜ë¥? ?‹´?? Map
	 *         currentPage = ?˜„?¬ ?˜?´ì§?
	 *         endPage = ë§ˆì?ë§? ?˜?´ì§?
	 *         prevPage = ?˜„?¬ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ?´? „ ?˜?´ì§? (?´? „ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ë§ˆì?ë§? ?˜?´ì§?)
	 *         nextPage = ?˜„?¬ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ?‹¤?Œ ?˜?´ì§? (?‹¤?Œ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ì²«ë²ˆì¨? ?˜?´ì§?)
	 *         nowStart = ?˜„?¬ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ?‹œ?‘ ?˜?´ì§?
	 *         nowEnd = ?˜„?¬ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ë§ˆì?ë§? ?˜?´ì§? 
	 * @author ê¹??„?˜„
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
		
		Integer listNum = (int)Math.ceil((double)currentPage/ listSize); // ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ?¸?±?Š¤
		Integer nextPage = 1 + listSize * listNum; // ?˜„?¬ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ?‹¤?Œ ?˜?´ì§? (?‹¤?Œ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ì²«ë²ˆì¨? ?˜?´ì§?)
		Integer prevPage = listNum== 1 ? 1 : nextPage - listSize - 1; // ?˜„?¬ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ?´? „ ?˜?´ì§? (?´? „ ?˜?´ì§? ë¦¬ìŠ¤?Š¸?˜ ë§ˆì?ë§? ?˜?´ì§?)
		Integer endPage = (int)Math.ceil((double)totalcount / pageSize); // ë§ˆì?ë§? ?˜?´ì§?
		
		// ?˜„?¬ ?˜?´ì§??˜ ë¦¬ìŠ¤?Š¸ ?‹œ?‘ê³? ?
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
	 * ê°?ì§?ê³? ?˜¬ ê²Œì‹œë¬? ?‹œ?‘ ?¸?±?Š¤ë¥? ë°˜í™˜?•˜?Š” ë©”ì†Œ?“œ
	 * @param currentPage ?˜„?¬ ?˜?´ì§?
	 * @param totalCount ? „ì²? ê²Œì‹œë¬? ?ˆ˜ 
	 * @param pageSize ?•œ ?˜?´ì§??˜ ê²Œì‹œë¬? ?ˆ˜ 
	 * @return ê°?ì§?ê³? ?˜¬ ê²Œì‹œë¬? ?‹œ?‘ ?¸?±?Š¤
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
