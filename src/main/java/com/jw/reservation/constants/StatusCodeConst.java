package com.jw.reservation.constants;

/**
 * api 상태 코드
 * @author wjddn
 *
 */
public enum StatusCodeConst {
	OK(200, "OK"),
	BAD_REQUEST(400, "BAD_REQUEST"),
	NOT_FOUNT(404, "NOT_FOUND"),
	INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");
	
	int statusCode;
	String code;
	
	StatusCodeConst(int statusCode, String code){
		this.statusCode = statusCode;
		this.code = code;
	}
}
