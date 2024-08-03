package org.example.service;

import org.example.dao.ClientDao;
import org.example.dao.model.Client;

public class ClientService {
    ClientDao clientDao = new ClientDao();

    public void save(Client client) {
        clientDao.save(client);
    }

    public Client findById(Long id) {
        return clientDao.findById(id);
    }

    public void update(Client client) {
        clientDao.update(client);
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }
}
