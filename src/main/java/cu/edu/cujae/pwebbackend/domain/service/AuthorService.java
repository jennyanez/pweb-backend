package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.AuthorDto;
import cu.edu.cujae.pwebbackend.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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

    public void saveAuthor(AuthorDto authorDto)throws SQLException{
        try{
            authorRepository.saveAuthor(authorDto);
        }catch (Exception e){
            throw new SQLException(e);
        }

    }

    public void updateAuthor(AuthorDto authorDto) throws SQLException{
        try{
            authorRepository.updateAuthor(authorDto);
        }catch (Exception e){
            throw new SQLException(e);
        }
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
