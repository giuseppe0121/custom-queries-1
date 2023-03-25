package co.develhope.customqueries1.controllers;


import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    Random random = new Random();

    @GetMapping("")
    public List<Flight> createFlight(){

        List<Flight> flights = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription(String.valueOf(random.nextInt()));
            flight.setFromAirport(String.valueOf(random.nextInt()));
            flight.setToAirport(String.valueOf(random.nextInt()));
            flight.setStatus(FlightStatus.ONTIME);
            flights.add(flightRepository.save(flight));
        }

        return flightRepository.findAll();
    }

}