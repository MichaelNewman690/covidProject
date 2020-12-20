package Covid19_project.Covid19_project.model;

import javax.persistence.*;

@Entity
@Table(name = "covid19trackerdata")
public class covid19TrackerModel {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "latestTotalCases")
    private int latestTotalCases;
    @Column(name = "diffFromPrevDay")
    private int diffFromPrevDay;

    public covid19TrackerModel(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases(){
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases){
        this.latestTotalCases=latestTotalCases;
    }

    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }

    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
