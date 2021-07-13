package com.jw.reservation.constants;

/**
 * 코드
 * @author wjddn
 *
 */
public enum CodeConst {
	
	/** 운영시간 타입 코드 */
	OPERATING_TP_CD_GRP("OPE001"),
	/** 운영 시간 타입 코드 : 평일(OPE001001) */
	OPERATING_TP_CD_WEEKDAY("OPE001001"),
	/** 운영 시간 타입 코드 : 토요일(OPE001002) */
	OPERATING_TP_CD_SAT("OPE001002"),
	/** 운영 시간 타입 코드 : 명절 당일(OPE001003) */
	OPERATING_TP_CD_HOLIDAY("OPE001003"),
	
	
	/** 의사 진료 코드 */
	DOCTOR_TP_CD_GRP("DOC001"),
	/** 의사 진료 코드 : 내과(DOC001001) */
	DOCTOR_TP_CD_MEDICINE("DOC001001"),
	
	/** 의사 진료 코드 : 소아과(DOC001002) */
	DOCTOR_TP_CD_PEDIATRICS("DOC001002"),
	
	/** 의사 진료 코드 : 이비인후과(DOC001003) */
	DOCTOR_TP_CD_OTO("DOC001003"),
	
	/** 의사 진료 코드 : 정형외과(DOC001004) */
	DOCTOR_TP_CD_ORTHO("DOC001004");
	
	private String value;
	
	CodeConst(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}
}
