package Covid19_project.Covid19_project.controller;

import Covid19_project.Covid19_project.model.covid19TrackerModel;
import Covid19_project.Covid19_project.service.covid19TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class covid19TrackerContoller {

    @Autowired
    private covid19TrackerService Covid19TrackerService;

    @GetMapping("/data")
    public String getAllData(Model model){
        List<covid19TrackerModel> allData = Covid19TrackerService.getAllData();
        int totalReportedCases = allData.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allData.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("allData", allData);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "data";
    }
}
