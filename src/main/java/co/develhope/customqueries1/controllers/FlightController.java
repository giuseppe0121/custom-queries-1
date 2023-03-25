package co.develhope.customqueries1.controllers;


import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

   /* @GetMapping("")
    public List<Flight> createFlight(){
        Random random = new Random();
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
    } */


    public String generateRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @GetMapping("")
    public List<Flight> provisionFlights(){
        List<Flight> newFlights = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            Flight flight = new Flight();
            flight.setDescription(generateRandomString());
            flight.setFromAirport(generateRandomString());
            flight.setToAirport(generateRandomString());
            flight.setStatus(FlightStatus.ONTIME);
            newFlights.add(flight);
        }
        return flightRepository.saveAll(newFlights);
    }



}