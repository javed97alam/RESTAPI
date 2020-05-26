package demo.boot.web;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    @RequestMapping(value = "/{messageId}")
    public String getCommentResource(@PathVariable("messageId") String messageId) {
        //test
        return messageId;
    }
}
