package Covid19_project.Covid19_project.service;

import Covid19_project.Covid19_project.model.covid19TrackerModel;
import Covid19_project.Covid19_project.repository.covid19TrackerRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class covid19TrackerService {

    private static final String URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    @Autowired
    private covid19TrackerRepository Covid19TrackerRepository;

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        int id = 1;
        for (CSVRecord record : records) {
            covid19TrackerModel Covid19TrackerModel = new covid19TrackerModel();
            Covid19TrackerModel.setId(id);
            Covid19TrackerModel.setState(record.get("Province/State"));
            Covid19TrackerModel.setCountry(record.get("Country/Region"));
            int lastCases = Integer.parseInt(record.get(record.size()-1));
            int prevDayCases = Integer.parseInt(record.get(record.size()-2));
            Covid19TrackerModel.setLatestTotalCases(lastCases);
            Covid19TrackerModel.setDiffFromPrevDay(lastCases-prevDayCases);
            Covid19TrackerRepository.save(Covid19TrackerModel);
            id++;
        }
    }

    public List<covid19TrackerModel> getAllData() {
        List<covid19TrackerModel> list = new ArrayList<>();
        Covid19TrackerRepository.findAll().forEach(list::add);
        return list;
    }
}
