package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Doctor {
	
	// �ǻ� �ĺ���ȣ
	private Long docId;
	// �ǻ� �̸�
	private String docNm;
	// �ǻ� ���� Ÿ��
	private String docTpCd;
	// �ǻ� ���� Ÿ�� ��
	private String docTpCdNm;
	// ���� ����
	private String delYn;
	// ��� �Ͻ�
	private Date regDt;
	// ���� �Ͻ�
	private Date modDt;
}
