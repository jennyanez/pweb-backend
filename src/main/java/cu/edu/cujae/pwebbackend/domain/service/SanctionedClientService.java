package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.SanctionedClientDto;
import cu.edu.cujae.pwebbackend.domain.repository.SanctionedClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SanctionedClientService {

    @Autowired
    private SanctionedClientRepository sanClientRepo;

    //Get all clients
    public List<SanctionedClientDto> getAll(){
        return sanClientRepo.getAll();
    }

    //get client by id
    public Optional<SanctionedClientDto> getSanctionedClient(Long sanctionedClientId){
        return sanClientRepo.getSanctionedClient(sanctionedClientId);
    }

}
