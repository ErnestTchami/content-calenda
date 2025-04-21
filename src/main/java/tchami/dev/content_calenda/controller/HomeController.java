package tchami.dev.content_calenda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tchami.dev.content_calenda.config.ContentCalendarPropeties;

import java.util.Map;
@RestController
public class HomeController {

   private final ContentCalendarPropeties propeties;

   public HomeController(ContentCalendarPropeties propeties){
       this.propeties=propeties;
   }

    @GetMapping("/")
   public ContentCalendarPropeties home(){
       return propeties;
    }
}
