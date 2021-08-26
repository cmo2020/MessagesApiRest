package messagesApiRest.Controller;

import messagesApiRest.Domain.Label;
import messagesApiRest.ServiceInterface.LabelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("label")
public class LabelController {

    private LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }


    @PostMapping
    public ResponseEntity<Label> createLabel(@RequestBody Label label) {
        labelService.createLabel(label);
        return new ResponseEntity<Label>(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Label> editLabel (@RequestBody String labelName, Label label){
        labelService.editLabel(labelName,label);
        return new ResponseEntity<Label>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Label> removeLabel (@RequestBody String labelName){
        labelService.removeLabel(labelName);
        return new ResponseEntity<Label>(HttpStatus.OK);
    }
}