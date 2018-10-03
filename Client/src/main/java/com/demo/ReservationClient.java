package com.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.Reservation;

@FeignClient(name="REGISTRATION-SERVICE", configuration=FeignConfiguration.class)
public interface ReservationClient {
	
	@RequestMapping(value="reservation/{reservationId}", method=RequestMethod.GET)
	  Reservation getReservation(@PathVariable("reservationId")  Integer id);

}
