package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.ClientDto;
import cu.edu.cujae.pwebbackend.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
    public void saveClient(ClientDto clientDto) throws SQLException {
        try {
            clientRepository.saveClient(clientDto);
        } catch (Exception e) {
            throw new SQLException(e);
        }

    }

    //update client
    public void updateClient(ClientDto clientDto) throws SQLException {
        try {
            clientRepository.updateClient(clientDto);
        } catch (Exception e) {
            throw new SQLException(e);
        }
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

    //check if is sanctioned
    public boolean isSanctioned(Long clientId){
        return clientRepository.isSanctioned(clientId);
    }


}
