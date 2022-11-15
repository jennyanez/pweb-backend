package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.DefaulterClientDto;
import cu.edu.cujae.pwebbackend.domain.repository.DefaulterClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaulterClientService {

    @Autowired
    private DefaulterClientRepository deClientRepo;

    //Get all clients
    public List<DefaulterClientDto> getAll(){
        return deClientRepo.getAll();
    }

    //get client by id
    public Optional<DefaulterClientDto> getDefaulterClient(Long defaulterClientId){
        return deClientRepo.getDefaulterClient(defaulterClientId);
    }

    //delete client
    public boolean deleteClient(Long defaulterClientId){
        if(deClientRepo.deleteDefaulterClient(defaulterClientId)){
            return true;
        }
        return false;
    }

}
