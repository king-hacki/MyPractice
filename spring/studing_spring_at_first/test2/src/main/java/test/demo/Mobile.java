package test.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mobile {

    long id;
    String content;

    Mobile (long id, String content) {
        this.id = id;
        this.content = content;
    }


}
