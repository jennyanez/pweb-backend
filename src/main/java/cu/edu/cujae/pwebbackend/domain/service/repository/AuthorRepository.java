package cu.edu.cujae.pwebbackend.domain.service.repository;

import cu.edu.cujae.pwebbackend.domain.dto.AuthorDto;
import cu.edu.cujae.pwebbackend.persistence.crud.AuthorCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Author;
import cu.edu.cujae.pwebbackend.persistence.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    @Autowired
    private AuthorCrudRepository authorCrudRepository;

    @Autowired
    private AuthorMapper mapper;

    /***    CRUD methods    ***/
    //Create
    public AuthorDto saveAuthor(AuthorDto authorDto){
        Author author = mapper.toAuthor(authorDto);
        return mapper.toAuthorDto(authorCrudRepository.save(author));
    }

    //Read
    public Optional<AuthorDto> getAuthor(Long authorId){
        return authorCrudRepository.findById(authorId).map(author ->
                mapper.toAuthorDto(author));
    }

    //Read All
    public List<AuthorDto> getAll(){
        List<Author> authorList = (List<Author>) authorCrudRepository.findAll();
        return mapper.toAuthorDtoList(authorList);
    }

    //Update
    public AuthorDto updateAuthor(AuthorDto authorDto, Long authorId){
        Author author = mapper.toAuthor(authorDto);
        author.setAuthorId(authorId);
        Author authorUpdt = authorCrudRepository.save(author);
        return mapper.toAuthorDto(authorUpdt);
    }

    //Delete
    public void deleteAuthor(Long authorId){
        authorCrudRepository.deleteById(authorId);
    }
}
