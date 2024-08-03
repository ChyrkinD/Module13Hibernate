package org.example;

import org.example.config.HibernateUtil;
import org.example.dao.model.Client;
import org.example.dao.model.Planet;
import org.example.dao.model.Ticket;
import org.example.service.ClientService;
import org.example.service.PlanetService;
import org.example.service.TicketService;
import org.flywaydb.core.Flyway;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5438/hibernate-h-w-13", "postgres", "password")
                .load();
        flyway.migrate();

        ClientService clientService = new ClientService();

        Client client = new Client();
        client.setName("Serafim");
        clientService.save(client);
        System.out.println(client);

        Client findByIdClient = clientService.findById(client.getId());
        System.out.println(findByIdClient);

        client.setName("Onufrii");
        clientService.update(client);
        Client clientAfterUpdate = clientService.findById(client.getId());
        System.out.println(clientAfterUpdate);

        clientService.delete(client);

        System.out.println("-------------------------------");
        PlanetService planetService = new PlanetService();

        Planet newPlanet = new Planet();
        newPlanet.setId("E327");
        newPlanet.setName("E-326");
        planetService.save(newPlanet);
        System.out.println("Created Planet = " + newPlanet);


        Planet currentPlanet = planetService.findById("E327");
        System.out.println("Current Planet = " + currentPlanet);


        currentPlanet.setName("E-327");
        planetService.update(currentPlanet);
        System.out.println("Current updated Planet = " + currentPlanet);


        planetService.delete(currentPlanet);
        System.out.println("Deleted Planet = " + currentPlanet);



        System.out.println("-------------------------------");
        TicketService ticketService = new TicketService();



        Planet newPlanetFrom = planetService.findById("VEN");
        System.out.println(newPlanetFrom);
        Planet newPlanetTo = planetService.findById("JUP");
        System.out.println(newPlanetTo);

        Client newClient = new Client();
        newClient.setName("Karkason");
        clientService.save(newClient);

        Ticket newTicket = new Ticket();
        newTicket.setClient(newClient);
        newTicket.setCreatedAt(LocalDate.now());
        newTicket.setFromPlanet(newPlanetFrom);
        newTicket.setToPlanet(newPlanetTo);


        ticketService.save(newTicket);
        System.out.println("Created Ticket = " + newTicket);


        Ticket currentTicket = ticketService.findById(2L);
        System.out.println("Current Ticket = " + currentTicket);


        currentTicket.setToPlanet(newPlanetTo);
        ticketService.update(currentTicket);
        System.out.println("Current updated Ticket = " + currentTicket);


        ticketService.delete(currentTicket);
        System.out.println("Deleted Ticket = " + currentTicket);


        HibernateUtil.getInstance().close();
    }
}