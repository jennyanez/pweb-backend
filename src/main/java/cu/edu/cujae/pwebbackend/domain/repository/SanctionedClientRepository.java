package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.SanctionedClientDto;
import cu.edu.cujae.pwebbackend.persistence.crud.SanctionedClientCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.SanctionedClient;
import cu.edu.cujae.pwebbackend.persistence.mapper.SanctionedClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class SanctionedClientRepository {
    @Autowired
    private SanctionedClientCrudRepository deClientCrudRepo;

    @Autowired
    private SanctionedClientMapper mapper;


    //** CRUD **//
    //Read
    public Optional<SanctionedClientDto> getSanctionedClient(Long sanctionedClientId){
        return deClientCrudRepo.findById(sanctionedClientId).map(sanctionedClient -> mapper.toSanctionedClientDto(sanctionedClient));
    }

    //Read all
    public List<SanctionedClientDto> getAll(){
        List<SanctionedClient> sanctionedClients = (List<SanctionedClient>) deClientCrudRepo.findAll();
        return mapper.toSanctionedClientDtoList(sanctionedClients);
    }
}
