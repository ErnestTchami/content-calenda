package tchami.dev.content_calenda.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tchami.dev.content_calenda.model.Content;
import tchami.dev.content_calenda.repository.ContentCollectionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

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

}
