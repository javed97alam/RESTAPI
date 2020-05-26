package demo.boot.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class CommentResource {

    @RequestMapping(value = "/{messageId}/comments/{commentsContent}")
    public String getCommentResource(
                      @PathVariable("messageId") String messageId, 
                      @PathVariable("commentsContent") String commentsContent) {
        //test
        return messageId + "/" + commentsContent;
    }
}