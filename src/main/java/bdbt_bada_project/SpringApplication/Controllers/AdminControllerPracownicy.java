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

import java.util.List;

@Controller
public class AdminControllerPracownicy {

    @Autowired
    private PracownicyDAO dao;

    @RequestMapping("/admin/dane_pracownikow")
    public String showAdminUserData(Model model) {
        List<Pracownicy> pracownicyList = dao.list();
        model.addAttribute("pracownicyList", pracownicyList);
        return "admin/pracownicyEntity/dane_pracownikow";
    }

    @RequestMapping(value = "/new")
    public String showNewForm(Model model) {
        Pracownicy pracownik = new Pracownicy();
        model.addAttribute("pracownik", pracownik);
        return "admin/pracownicyEntity/new_form_pracownicy";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy){
        dao.save(pracownicy);
        return "redirect:/admin/dane_pracownikow";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/pracownicyEntity/edit_form_pracownicy");
        Pracownicy pracownicy = dao.get(id);
        mav.addObject("pracownicy", pracownicy);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownicy") Pracownicy pracownicy){
        dao.update(pracownicy);

        return "redirect:/admin/dane_pracownikow";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);

        return "redirect:/admin/dane_pracownikow";
    }

}


