package tchami.dev.content_calenda.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.model.Status;
import tchami.dev.content_calenda.repository.ContentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
//    private final ContentCollectionRepository repository;


 private final ContentRepository repository;
    public ContentController(ContentRepository repository){
        this.repository =repository;
    }

//    make the route visible to the app level
    @GetMapping("")
    public List<Content> findAll(){
        return  repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content ,@PathVariable Integer id ){
        if(!repository.existsById(id)){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND");
        }
        repository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"CONTENT NOT FOUND");
        }
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public  List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable @Valid Status status){
        return repository.listAllByStatus(status);
    }
}
