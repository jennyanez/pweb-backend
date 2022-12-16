package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.SanctionDto;
import cu.edu.cujae.pwebbackend.domain.repository.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SanctionService {

    @Autowired
    private SanctionRepository sanctionRepository;

    //get all sanctions
    public List<SanctionDto> getAll() {
        return sanctionRepository.getAll();
    }

    //get sanction by id
    public Optional<SanctionDto> getById(Long id) {
        return sanctionRepository.getSanctionById(id);
    }

    //create sanction
    public SanctionDto createSanction(SanctionDto sanctionDto) {
        return sanctionRepository.saveSanction(sanctionDto);
    }

    // delete sanction
    public boolean deleteSanction(Long id) {
        try {
            sanctionRepository.deleteSanction(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
