package org.example.service;

import org.example.dao.TicketDao;
import org.example.dao.model.Client;
import org.example.dao.model.Planet;
import org.example.dao.model.Ticket;

public class TicketService {
    private TicketDao ticketDao = new TicketDao();

    public void save(Ticket ticket) {
        Client client = ticket.getClient();
        Planet fromPlanet = ticket.getFromPlanet();
        Planet toPlanet = ticket.getToPlanet();

        if (fromPlanet == null || toPlanet == null || client == null) {
            throw new RuntimeException();
        }

        ClientService clientService = new ClientService();
        if(clientService.findById(client.getId()) == null) {
            throw new RuntimeException();
        }

        PlanetService planetService = new PlanetService();
        if(planetService.findById(toPlanet.getId()) == null
            || planetService.findById(fromPlanet.getId()) == null){
            throw new RuntimeException();
        }

        ticketDao.save(ticket);
    }

    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
