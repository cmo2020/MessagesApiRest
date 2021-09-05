package messagesApiRest.Controller;

import messagesApiRest.Domain.Label;
import messagesApiRest.Service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("label")
public class LabelController {

    private ILabelService labelService;

    @Autowired
    public LabelController(ILabelService labelService) {
        this.labelService = labelService;
    }


    @PostMapping("/create")
    public ResponseEntity<Label> createLabel(@RequestBody Label label) {
        labelService.createLabel(label);
        return new ResponseEntity<Label>(HttpStatus.CREATED);

    }

    @PutMapping("/edit")
    public ResponseEntity<Label> editLabel(@RequestBody String labelName, Label label) {
        labelService.editLabel(labelName, label);
        return new ResponseEntity<Label>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public String removeLabel(@PathVariable("id")@RequestBody Long id) {
        labelService.removeLabel(id);
        return  "label removed";
    }


    @PostMapping("/addLabel")
    public ResponseEntity<Object> addLabel( @RequestParam("idLabel") Long labelId, @RequestParam("idMessage") Long messageId) {
       labelService.addLabel(labelId, messageId);
        return new ResponseEntity<Object>(HttpStatus.OK);

    }


}