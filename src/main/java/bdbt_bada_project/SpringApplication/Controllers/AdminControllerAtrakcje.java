package bdbt_bada_project.SpringApplication.Controllers;
import bdbt_bada_project.SpringApplication.Entities.Atrakcje;
import bdbt_bada_project.SpringApplication.Entities.AtrakcjeDAO;
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
public class AdminControllerAtrakcje {

    @Autowired
    private AtrakcjeDAO dao;

    @RequestMapping("/admin/dane_atrakcji")
    public String showAdminUserData(Model model) {
        List<Atrakcje> atrakcjeList = dao.list();
        model.addAttribute("atrakcjeList", atrakcjeList);
        return "admin/AtrakcjeAdminEntity/dane_atrakcji";
    }

    @RequestMapping(value = "/newA")
    public String showNewForm(Model model) {
        Atrakcje atrakcje = new Atrakcje();
        model.addAttribute("atrakcje", atrakcje);
        return "admin/AtrakcjeAdminEntity/new_form_atrakcje";
    }

    @RequestMapping(value="/saveA", method = RequestMethod.POST)
    public String save(@ModelAttribute("atrakcje") Atrakcje atrakcje){
        dao.save(atrakcje);
        return "redirect:/admin/dane_atrakcji";
    }

    @RequestMapping("/editA/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("admin/AtrakcjeAdminEntity/edit_form_atrakcje");
        Atrakcje atrakcje = dao.get(id);
        mav.addObject("atrakcje", atrakcje);
        return mav;
    }

    @RequestMapping(value = "/updateA", method = RequestMethod.POST)
    public String update(@ModelAttribute("atrakcje") Atrakcje atrakcje){
        dao.update(atrakcje);

        return "redirect:/admin/dane_atrakcji";
    }

    @RequestMapping("/deleteA/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);

        return "redirect:/admin/dane_atrakcji";
    }

}
