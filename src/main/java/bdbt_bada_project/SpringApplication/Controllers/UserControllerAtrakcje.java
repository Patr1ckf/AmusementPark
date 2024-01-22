//package bdbt_bada_project.SpringApplication.Controllers;
//import bdbt_bada_project.SpringApplication.Entities.Atrakcje;
//import bdbt_bada_project.SpringApplication.Entities.AtrakcjeDAO;
//import bdbt_bada_project.SpringApplication.Entities.Pracownicy;
//import bdbt_bada_project.SpringApplication.Entities.PracownicyDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//public class UserControllerAtrakcje {
//    @Autowired
//    private AtrakcjeDAO dao1;
//
//    @RequestMapping("/user/dane_atrakcji")
//    public String showUserUserData(Model model) {
//        List<Atrakcje> atrakcjeList = dao1.list();
//        model.addAttribute("atrakcjeList", atrakcjeList);
//        return "user/atrakcjeEntity/dane_atrakcji";
//    }
//
//    @RequestMapping(value = "/new")
//    public String showNewForm(Model model) {
//        Atrakcje atrakcja = new Atrakcje();
//        model.addAttribute("atrakcja", atrakcja);
//        return "user/atrakcjeEntity/new_form_atrakcje";
//    }
//
//    @RequestMapping(value="/save", method = RequestMethod.POST)
//    public String save(@ModelAttribute("atrakcje") Atrakcje atrakcje){
//        dao1.save(atrakcje);
//        return "redirect:/user/dane_atrakcji";
//    }
//
//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("user/atrakcjeEntity/edit_form_atrakcje");
//        Atrakcje atrakcje = dao1.get(id);
//        mav.addObject("atrakcje", atrakcje);
//        return mav;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String update(@ModelAttribute("atrakcje") Atrakcje atrakcje){
//        dao1.update(atrakcje);
//
//        return "redirect:/user/dane_atrakcji";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable(name = "id") int id){
//        dao1.delete(id);
//
//        return "redirect:/user/dane_atrakcji";
//    }
//
//}
//
