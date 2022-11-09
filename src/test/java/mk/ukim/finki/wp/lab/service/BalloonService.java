package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;


public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> getAllSizes();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> searchById(Long id);
    Balloon editBalloon(Long id, String name, String description, Manufacturer manufacturer);
    void deleteById(Long id);
    Balloon addNewBalloon(String name, String description, Manufacturer manufacturer);
}
