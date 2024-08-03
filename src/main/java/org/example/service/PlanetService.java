package org.example.service;

import org.example.dao.PlanetDao;
import org.example.dao.model.Planet;

public class PlanetService {
    private PlanetDao planetDao = new PlanetDao();

    public void save(Planet planet) {
        planetDao.save(planet);
    }

    public Planet findById(String id) {
        return planetDao.findById(id);
    }

    public void update(Planet planet) {
        planetDao.update(planet);
    }

    public void delete(Planet planet) {
        planetDao.delete(planet);
    }
}
