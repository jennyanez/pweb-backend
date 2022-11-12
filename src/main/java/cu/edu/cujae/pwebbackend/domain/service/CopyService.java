package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.CopyDto;
import cu.edu.cujae.pwebbackend.domain.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CopyService {
    @Autowired
    private CopyRepository copyRepository;

    public List<CopyDto> getAll(){
        return copyRepository.getAll();
    }

    public Optional<CopyDto> getCopy(Long copyId){
        return copyRepository.getCopy(copyId);
    }

    public CopyDto saveCopy(CopyDto copyDto){
        return copyRepository.saveCopy(copyDto);
    }

    public CopyDto updateCopy(CopyDto copyDto, Long copyId){
        return copyRepository.updateCopy(copyDto, copyId);
    }

    public void deleteCopy(Long copyId){
        copyRepository.deleteCopy(copyId);
    }


}
