package com.jw.practice.model;

import com.jw.reservation.constants.StatusCodeConst;

import lombok.Data;

@Data
public class Message {
	private StatusCodeConst status;
	private String message;
	private Object data;
	
	public Message() {
		this.status = StatusCodeConst.BAD_REQUEST;
        this.data = null;
        this.message = null;
	}
}
