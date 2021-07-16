package com.jw.reservation.repository;

import org.apache.ibatis.annotations.Mapper;

import com.jw.reservation.model.Holiday;

@Mapper
public interface HolidayDao {

	Integer insert(Holiday holiday);

	Integer modify(Holiday holiday);

	Holiday getHoliday(Holiday holiday);

}
