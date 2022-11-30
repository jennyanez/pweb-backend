package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.ClientDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

//no se, esto estaba ahi ya cuando llegue
@Mapper(componentModel = "spring")
public interface ClientMapper {

    //mapeando los atributos de las clases
    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "clientId", target = "clientId"),
                    @org.mapstruct.Mapping(source = "DNI", target = "DNI"),
                    @org.mapstruct.Mapping(source = "area", target = "area"),
                    @org.mapstruct.Mapping(source = "name", target = "name"),
                    @org.mapstruct.Mapping(source = "firstSurname", target = "firstSurname"),
                    @org.mapstruct.Mapping(source = "lastSurname", target = "lastSurname"),
                    @org.mapstruct.Mapping(target = "copyList", ignore = true),
            }
    )
    //convertir un dto cliente en una entidad cliente
    Client toClient(ClientDto client);
    //convertir una lista de dto de tipo cliente (ClientDto) en una lista de de entidades de tipo cliente (entity)
    List<Client> toClientList(List<ClientDto> clientDtoList);


    @InheritInverseConfiguration
    //lo mismo de arriba pero la operacion inversa
    ClientDto toClientDto(Client client);
    List<ClientDto> toClientDtoList(List<Client> clientList);

}
