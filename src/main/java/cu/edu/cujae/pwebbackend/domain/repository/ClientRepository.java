package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.ClientDto;
import cu.edu.cujae.pwebbackend.domain.dto.SanctionDto;
import cu.edu.cujae.pwebbackend.persistence.crud.ClientCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Client;
import cu.edu.cujae.pwebbackend.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper mapper;

    @Autowired
    private SanctionRepository sanctionRepository;

    //** CRUD **//
    //Create
    public ClientDto saveClient(ClientDto clientDto){
        Client client = mapper.toClient(clientDto);
        return mapper.toClientDto(clientCrudRepository.save(client));
    }

    //Read
    public Optional<ClientDto> getClient(Long clientId){
        return clientCrudRepository.findById(clientId).map(client -> mapper.toClientDto(client));
    }

    //Read all
    public List<ClientDto> getAll(){
        List<Client> clients = (List<Client>) clientCrudRepository.findAll();
        return mapper.toClientDtoList(clients);
    }

    //Update
    public ClientDto updateClient(ClientDto clientDto){
        Client client = mapper.toClient(clientDto);
        Client clientUpdated = clientCrudRepository.save(client);
        return mapper.toClientDto(clientUpdated);
    }

    //Delete
    public boolean deleteClient(Long clientId){
        clientCrudRepository.deleteById(clientId);
        return true;
    }

    /// check if is sanctioned
    public boolean isSanctioned(Long clientId){
        List<SanctionDto> sanctions = sanctionRepository.getAll();
        for (SanctionDto sanction : sanctions) {
            if(Objects.equals(sanction.getClient().getClientId(), clientId)){
                return true;
            }
        }
        return false;
    }

}
