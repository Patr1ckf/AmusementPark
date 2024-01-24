package bdbt_bada_project.SpringApplication.Controllers;
import bdbt_bada_project.SpringApplication.Entities.AtrakcjeDAO;
import bdbt_bada_project.SpringApplication.Entities.PracownicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private PracownicyDAO dao;
    private AtrakcjeDAO dao1;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/new").setViewName("admin/pracownicyEntity/new_form_pracownicy");
        registry.addViewController("/save").setViewName("admin/pracownicyEntity/dane_pracownikow");
        registry.addViewController("/edit{id}").setViewName("admin/pracownicyEntity/edit_form_pracownicy");
        registry.addViewController("/delete").setViewName("admin/pracownicyEntity/dane_pracownikow");
        registry.addViewController("/newW").setViewName("admin/wynagrodzeniaEntity/new_form_wynagrodzenia");
        registry.addViewController("/saveW").setViewName("admin/wynagrodzeniaEntity/new_form_wynagrodzenia");
        registry.addViewController("/newA").setViewName("admin/AtrakcjeAdminEntity/new_form_atrakcje");
        registry.addViewController("/saveA").setViewName("admin/AtrakcjeAdminEntity/dane_atrakcji");

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




