package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	
	// ���� �ĺ���ȣ
	private Long resId;
	// ȯ�� �ĺ���ȣ
	private Long mbrId;
	// �ǻ� �ĺ���ȣ
	private Long docId;
	
	// ������
	private Date resDt;
	// ���� ���� �Ͻ�
	private Date resStDt;
	// ���� ��� �ð�
	private Date resMt;
	// ���� ���� �Ͻ�
	private Date resEndDt;
	
	// ���� ����
	private String delYn;
	// ��� �Ͻ�
	private Date regDt;
	// ���� �Ͻ�
	private Date modDt;
}
