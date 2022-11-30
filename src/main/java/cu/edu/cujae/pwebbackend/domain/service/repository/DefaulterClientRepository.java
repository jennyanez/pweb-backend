package cu.edu.cujae.pwebbackend.domain.service.repository;

import cu.edu.cujae.pwebbackend.domain.dto.DefaulterClientDto;
import cu.edu.cujae.pwebbackend.persistence.crud.DefaulterClientCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.DefaulterClient;
import cu.edu.cujae.pwebbackend.persistence.mapper.DefaulterClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaulterClientRepository {

    @Autowired
    private DefaulterClientCrudRepository deClientCrudRepo;

    @Autowired
    private DefaulterClientMapper mapper;

    //** CRUD **//
    //Read
    public Optional<DefaulterClientDto> getDefaulterClient(Long defaulterClientId){
        return deClientCrudRepo.findById(defaulterClientId).map(defaulterClient -> mapper.toDefaulterClientDto(defaulterClient));
    }

    //Read all
    public List<DefaulterClientDto> getAll(){
        List<DefaulterClient> defaulterClients = (List<DefaulterClient>) deClientCrudRepo.findAll();
        return mapper.toDefaulterClientDtoList(defaulterClients);
    }


    //Delete
    public boolean deleteDefaulterClient(Long defaulterClientId){
        deClientCrudRepo.deleteById(defaulterClientId);
        return true;
    }
}
