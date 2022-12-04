package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.CopyDto;
import cu.edu.cujae.pwebbackend.persistence.crud.BookCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.CopyCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.LoanCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Copy;
import cu.edu.cujae.pwebbackend.persistence.mapper.BookMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.CopyMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CopyRepository {
    @Autowired
    private CopyCrudRepository copyCrudRepository;

    @Autowired
    private CopyMapper mapper;

    @Autowired
    private BookCrudRepository bookCrudRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private LoanMapper loanMapper;

    @Autowired
    private LoanCrudRepository loanCrudRepository;


    /**** CRUD methods ****/
    //create
    public CopyDto saveCopy(CopyDto copyDto){
        Copy copy = mapper.toCopy(copyDto);
        copy.setBook(bookMapper.toBook(copyDto.getBook()));
        return mapper.toCopyDto(copyCrudRepository.save(copy));
    }

    //read
    public Optional<CopyDto> getCopy(Long copyId){
        return copyCrudRepository.findById(copyId).map(copy -> mapper.toCopyDto(copy));
    }

    //read all
    public List<CopyDto> getAll(){
        List<Copy> copies = (List<Copy>) copyCrudRepository.findAll();
        return mapper.toCopyDtoList(copies);
    }

    //update
    public CopyDto updateCopy(CopyDto copyDto, Long copyId){
        Copy copy = mapper.toCopy(copyDto);
        copy.setCopyId(copyId);
        Copy copyUpd = copyCrudRepository.save(copy);
        return mapper.toCopyDto(copyUpd);
    }

    //delete
    public void deleteCopy(Long copyId){
        copyCrudRepository.deleteById(copyId);
    }
}
