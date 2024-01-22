package bdbt_bada_project.SpringApplication.Controllers;
import bdbt_bada_project.SpringApplication.Entities.Pracownicy;
import bdbt_bada_project.SpringApplication.Entities.PracownicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private PracownicyDAO dao;

    @RequestMapping(value = "/new")
    public String showNewForm(Model model) {
        Pracownicy pracownik = new Pracownicy();
        model.addAttribute("pracownik", pracownik);
        return "admin/new_form";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy){
        dao.save(pracownicy);
        return "redirect:/main_admin";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/edit_form");
        Pracownicy pracownicy = dao.get(id);
        mav.addObject("pracownicy", pracownicy);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownicy") Pracownicy pracownicy){
        dao.update(pracownicy);

        return "redirect:/main_admin";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);

        return "redirect:/main_admin";
    }

}


