package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.dataholders.DataHolder;
import mk.ukim.finki.wp.lab.exceptions.BalloonAlreadyExists;
import mk.ukim.finki.wp.lab.exceptions.BalloonDoesntExistException;
import mk.ukim.finki.wp.lab.exceptions.ManufacturerDoesntExist;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons() {
        return DataHolder.balloons;
    }
    public List<Balloon> getAllSizes() {
        return DataHolder.sizes;
    }


    public List<Balloon> findAllByNameOrDescription(String text) {
        List<Balloon> foundBalloons = new ArrayList<>();
        for (Balloon elem: DataHolder.balloons) {
            if(elem.getName().contains(text) || elem.getDescription().contains(text)) {
                foundBalloons.add(elem);
            }
        }
        return foundBalloons;
    }

    public Optional<Balloon> findById(Long id) {
        return DataHolder.balloons.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public void deleteCourseById(Long id){
        try{
            DataHolder.balloons.remove(this.findById(id).orElseThrow(BalloonDoesntExistException::new));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Balloon addBalloon(Balloon balloon) throws BalloonAlreadyExists, ManufacturerDoesntExist {
        if (DataHolder.balloons.stream().anyMatch(i->i.getName().equals(balloon.getName()))){
            throw new BalloonAlreadyExists();
        }
        DataHolder.balloons.add(balloon);
        return balloon;
    }

    public Balloon editBalloon(Long id, String name, String description, Manufacturer manufacturer) throws BalloonAlreadyExists{
        if (DataHolder.balloons.stream().anyMatch(i->i.getName().equals(name))){
            throw new BalloonAlreadyExists();
        }
        Balloon balloon = DataHolder.balloons.stream().filter(i->i.getId().equals(id)).findFirst().orElseThrow(BalloonDoesntExistException::new);
        balloon.setName(name);
        balloon.setDescription(description);
        balloon.setManufacturer(manufacturer);
        if(DataHolder.balloons.stream().anyMatch(i->i.getId().equals(id))){
            DataHolder.balloons.remove(DataHolder.balloons.stream().filter(i->i.getId().equals(id)).findFirst().get());
            DataHolder.balloons.add(balloon);
        }
        return balloon;
    }
}
