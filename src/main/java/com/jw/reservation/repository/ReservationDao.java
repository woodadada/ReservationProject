package com.jw.reservation.repository;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jw.reservation.form.ReservationForm;
import com.jw.reservation.model.Reservation;

@Mapper
public interface ReservationDao {

	List<Reservation> getList(ReservationForm form);

	Integer insert(Reservation reservation);

	Integer modify(Reservation reservation);

	Integer checkReservation(Reservation reservation);
	
	List<Reservation> getReservationList(Reservation reservation);
}
