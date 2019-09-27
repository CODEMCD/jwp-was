package view;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import db.DataBase;
import http.MimeType;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;

public class ModelAndViewTest {

    @Test
    void Handlebars_test() {
        User user1 = new User("park1", "park", "park1", "park2@naver.com");
        User user2 = new User("park2", "park", "park2", "park2@naver.com");

        DataBase.addUser(user1);
        DataBase.addUser(user2);
        Collection<User> users = DataBase.findAll();

        Model model = new Model();
        model.setAttribute("users", users);

        TemplateLoader loader = new ClassPathTemplateLoader();
        loader.setPrefix("/templates");
        loader.setSuffix(".html");
        Handlebars handlebars = new Handlebars(loader);

        try {
            Template template = handlebars.compile("user/list");
            String listPage = template.apply(model.getAttributes());
            System.out.println(listPage);
        } catch (IOException e) { }
    }
}
