package com.jw.reservation.repository;

import org.apache.ibatis.annotations.Mapper;

import com.jw.reservation.model.Doctor;

@Mapper
public interface DoctorDao {
	
	/**
	 * 의사 등록
	 * @param doctor
	 * @return
	 */
	Integer insert(Doctor doctor);

	/**
	 * 의사 수정
	 * @param doctor
	 * @return
	 */
	Integer modify(Doctor doctor);
	
}
