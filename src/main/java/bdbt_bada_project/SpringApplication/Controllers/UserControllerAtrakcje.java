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
public class UserControllerAtrakcje {
    @Autowired
    private AtrakcjeDAO dao;

    @RequestMapping("/user/dane_atrakcji")
    public String showUserUserData(Model model) {
        List<Atrakcje> atrakcjeList = dao.list();
        model.addAttribute("atrakcjeList", atrakcjeList);
        return "user/AtrakcjeEntity/dane_atrakcji";
    }

    @RequestMapping(value = "/newAtrakcje")
    public String showNewForm(Model model) {
        Atrakcje atrakcje = new Atrakcje();
        model.addAttribute("atrakcja", atrakcje);
        return "user/AtrakcjeEntity/new_form_atrakcje";
    }

    @RequestMapping(value="/saveAtrakcje", method = RequestMethod.POST)
    public String save(@ModelAttribute("atrakcje") Atrakcje atrakcje){
        dao.save(atrakcje);
        return "redirect:/user/dane_atrakcji";
    }

    @RequestMapping("/editAtrakcje/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("user/AtrakcjeEntity/edit_form_atrakcje");
        Atrakcje atrakcje = dao.get(id);
        mav.addObject("atrakcje", atrakcje);
        return mav;
    }

    @RequestMapping(value = "/updateAtrakcje", method = RequestMethod.POST)
    public String update(@ModelAttribute("atrakcje") Atrakcje atrakcje){
        dao.update(atrakcje);

        return "redirect:/user/dane_atrakcji";
    }

    @RequestMapping("/deleteAtrakcje/{id}")
    public String delete(@PathVariable(name = "id") int id){
        dao.delete(id);

        return "redirect:/user/dane_atrakcji";
    }

}

