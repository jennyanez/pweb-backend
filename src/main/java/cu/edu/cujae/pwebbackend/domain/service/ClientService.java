package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.ClientDto;
import cu.edu.cujae.pwebbackend.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //Get all clients
    public List<ClientDto> getAll(){
        return clientRepository.getAll();
    }

    //get client by id
    public Optional<ClientDto> getClient(Long clientId){
        return clientRepository.getClient(clientId);
    }

    //create client
    public ClientDto saveClient(ClientDto clientDto){
        return clientRepository.saveClient(clientDto);
    }

    //update client
    public ClientDto updateClient(ClientDto clientDto){
        return clientRepository.updateClient(clientDto);
    }

    //delete client
    public boolean deleteClient(Long clientId){
        try{
            clientRepository.deleteClient(clientId);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }


}
