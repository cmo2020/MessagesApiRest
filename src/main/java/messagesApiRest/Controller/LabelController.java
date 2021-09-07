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
    public Object createLabel(@RequestBody Label label) {
        labelService.createLabel(label);
        return  "label saved";

    }



    @DeleteMapping("/remove")
    public String removeLabel(@RequestParam("idLabel") Long id) {
        labelService.removeLabel(id);
        return  "label removed";
    }


    @PostMapping("/addLabel")
    public ResponseEntity<Object> addLabel( @RequestParam("idLabel") Long labelId, @RequestParam("idMessage") Long messageId) {
       labelService.addLabel(labelId, messageId);
        return new ResponseEntity<Object>(HttpStatus.OK);

    }


}