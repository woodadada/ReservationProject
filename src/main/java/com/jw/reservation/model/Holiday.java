package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Holiday {
	
	// �޹��� �ĺ���ȣ
	private Long holiId;
	// �ǻ� �ĺ���ȣ
	private Long docId;
	// �޹���
	private Date holiDt;
	// ���� ����
	private String delYn;
	// ��� �Ͻ�
	private Date regDt;
	// ���� �Ͻ�
	private Date modDt;
}
