package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Calendar {
	
	// ����
	private Date de;
	// �����
	private String ymd;
	// ����
	private Integer yr;
	// ��
	private Integer mt;
	// ��
	private Integer dy;
	// ����
	private Integer dwk;
	// ���Ͽ���
	private String hoilYn;
	// �������� ����
	private String hldyYn;
	// ���
	private String note;
	// ��� �Ͻ�
	private Date regDt;
}
