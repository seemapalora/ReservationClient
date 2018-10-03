package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Reservation;

@RestController
public class ClientController {
	@Autowired
	ReservationClient reservationClient;

	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping(value = "/reservation-feign/{reservationId}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable("reservationId") Integer id) {
		return reservationClient.getReservation(id);
	}

	@RequestMapping(value = "/reservation-loadbalancer/{reservationId}", method = RequestMethod.GET)
	public Reservation getReservationLB(@PathVariable("reservationId") Integer id) {
		ServiceInstance serviceInstance = loadBalancer.choose("REGISTRATION-SERVICE");
		RestTemplate template = new RestTemplate();
		ResponseEntity<Reservation> response = null;
		try {
			response = template.exchange(serviceInstance.getUri()+"/reservation/"+id, HttpMethod.GET, null, Reservation.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();

	}
	
	@RequestMapping(value = "/reservation-template/{reservationId}", method = RequestMethod.GET)
	public Reservation getReservationTemplate(@PathVariable("reservationId") Integer id) {

		ResponseEntity<Reservation> response = null;
		try {
			response = restTemplate.exchange("http://REGISTRATION-SERVICE/reservation/"+id, HttpMethod.GET, null, Reservation.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return response.getBody();

	}
}
