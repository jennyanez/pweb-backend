package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.AuthorDto;
import cu.edu.cujae.pwebbackend.domain.service.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> getAll(){
        return authorRepository.getAll();
    }

    public Optional<AuthorDto> getAuthor(Long authorId){
        return authorRepository.getAuthor(authorId);
    }

    public AuthorDto saveAuthor(AuthorDto authorDto){
        return authorRepository.saveAuthor(authorDto);
    }

    public AuthorDto updateAuthor(AuthorDto authorDto, Long authorId){
        return authorRepository.updateAuthor(authorDto, authorId);
    }

    public boolean deleteAuthor(Long authorId){
        try{
            authorRepository.deleteAuthor(authorId);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }

    }
}
