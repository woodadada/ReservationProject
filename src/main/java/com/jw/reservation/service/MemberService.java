package com.jw.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.reservation.repository.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
		
}
