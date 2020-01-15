package pl.wlodarczyk.kolokwium.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wlodarczyk.kolokwium.models.Retangle;
import pl.wlodarczyk.kolokwium.repo.RetangleRepo;
import java.util.Collection;


@Service
public class RetangleService {

    private RetangleRepo retangleRepo;

    @Autowired
    public RetangleService(RetangleRepo retangleRepo) {
        this.retangleRepo = retangleRepo;
    }

    public void add(Retangle retangle){
        retangleRepo.save(retangle);
    }

    public Collection<Retangle> showAll(){
        return retangleRepo.findAll();
    }

}
