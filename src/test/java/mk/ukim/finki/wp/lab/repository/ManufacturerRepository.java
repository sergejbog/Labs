package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.dataholders.DataHolder;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> findAllManufacturers() {
        return DataHolder.manufacturerList;
    }
    public Manufacturer findById(Long id) {
        return DataHolder.manufacturerList.stream().filter(carnet -> id.equals(carnet.getId())).findFirst().orElse(null);
    }
}
