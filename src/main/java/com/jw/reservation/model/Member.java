package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	
	// ȯ�� �ĺ���ȣ
	private Long mbrId;
	// ȯ�� �̸�
	private String mbrNm;
	// ȯ�� ��ȭ��ȣ
	private String mbrCpNo;
	// ��� �Ͻ�
	private Date regDt;
	// ���� �Ͻ�
	private Date modDt;
}
