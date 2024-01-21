package bdbt_bada_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private PracownicyDAO dao;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/new").setViewName("new_form");
        registry.addViewController("/save").setViewName("admin/main_admin");
    }


    @Controller
    public class DashboardController
    {
        @RequestMapping("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else {
                return "redirect:/index";
            }
        }
    }

    @Controller
    public class UserController {

        @RequestMapping("/main_admin")
        public String showUserData(Model model, HttpServletRequest request) {
            List<Pracownicy> pracownicyList = dao.list();
            model.addAttribute("pracownicyList", pracownicyList);

            if (request.isUserInRole("ADMIN")) {
                return "admin/main_admin";
            } else {
                return "redirect:/main_user";
            }
        }
    }

    @Controller
    public class NowyPracownik {

        @RequestMapping(value = "/new")
        public String showNewForm(Model model) {
            Pracownicy pracownik = new Pracownicy();
            model.addAttribute("pracownik", pracownik);
            return "new_form";
        }
    }

    @Controller
    public class SaveController {
        @RequestMapping(value="/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy){
            dao.save(pracownicy);
            return "redirect:/main_admin";
        }
    }


    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}





