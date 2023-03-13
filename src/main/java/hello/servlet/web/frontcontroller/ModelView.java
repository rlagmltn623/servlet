package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class ModelView {
    private String viewName;
    private Map<String , Object> model = new HashMap<>();

    //생성자로 뷰의 이름
    public ModelView(String viewName) {
        this.viewName = viewName;
   }


}
