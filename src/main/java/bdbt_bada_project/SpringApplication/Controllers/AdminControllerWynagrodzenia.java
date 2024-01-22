package bdbt_bada_project.SpringApplication.Controllers;

import bdbt_bada_project.SpringApplication.Entities.Wynagrodzenia;
import bdbt_bada_project.SpringApplication.Entities.WynagrodzeniaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminControllerWynagrodzenia {

    @Autowired
    private WynagrodzeniaDAO dao;

    @RequestMapping("/admin/wynagrodzenia")
    public String showAdminUserData(Model model) {
        List<Wynagrodzenia> wynagrodzeniaList = dao.list();
        model.addAttribute("wynagrodzeniaList", wynagrodzeniaList);
        return "/admin/wynagrodzeniaEntity/wynagrodzenia";
    }

    @RequestMapping(value = "/newW")
    public String showNewForm(Model model) {
        Wynagrodzenia wynagrodzenia = new Wynagrodzenia();
        model.addAttribute("wynagrodzenia", wynagrodzenia);
        return "admin/wynagrodzeniaEntity/new_form_wynagrodzenia";
    }

    @RequestMapping(value="/saveW", method = RequestMethod.POST)
    public String save(@ModelAttribute("wynagrodzenia") Wynagrodzenia wynagrodzenia){
        dao.save(wynagrodzenia);
        return "redirect:/admin/wynagrodzenia";
    }

    @RequestMapping("/editW/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/wynagrodzeniaEntity/edit_form_wynagrodzenia");
        Wynagrodzenia wynagrodzenia = dao.get(id);
        mav.addObject("wynagrodzenia", wynagrodzenia);
        return mav;
    }

    @RequestMapping(value = "/updateW", method = RequestMethod.POST)
    public String update(@ModelAttribute("wynagrodzenia") Wynagrodzenia wynagrodzenia){
        dao.update(wynagrodzenia);

        return "redirect:/admin/wynagrodzenia";
    }

    @RequestMapping("/deleteW/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);

        return "redirect:/admin/wynagrodzenia";
    }

}
