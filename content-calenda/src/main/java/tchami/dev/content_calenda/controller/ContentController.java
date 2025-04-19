package tchami.dev.content_calenda.controller;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.repository.ContentCollectionRepository;
import tchami.dev.content_calenda.repository.ContentJdbcTemplateRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentCollectionRepository repository;


//    here if you want you can use the repository from jdbcTemplate same as the first one
//    private final ContentJdbcTemplateRepository jdbcTemplateRepository;

    public ContentController(ContentCollectionRepository repository){
        this.repository =repository;
    }

//    make the route visible to the app level
    @GetMapping("")
    public List<Content> findAll(){
        return  repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.finById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.add(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content ,@PathVariable Integer id ){
        if(!repository.existsById(id)){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND");
        }
        repository.add(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND");
        }
        repository.delete(id);
    }
}
