
package com.madhan.soccerscores.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fixture {

    @SerializedName("_links")
    @Expose
    private com.madhan.soccerscores.Models.Links Links;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("homeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("awayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("result")
    @Expose
    private Result result;

    /**
     * 
     * @return
     *     The Links
     */
    public com.madhan.soccerscores.Models.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.madhan.soccerscores.Models.Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The matchday
     */
    public Integer getMatchday() {
        return matchday;
    }

    /**
     * 
     * @param matchday
     *     The matchday
     */
    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    /**
     * 
     * @return
     *     The homeTeamName
     */
    public String getHomeTeamName() {
        return homeTeamName;
    }

    /**
     * 
     * @param homeTeamName
     *     The homeTeamName
     */
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    /**
     * 
     * @return
     *     The awayTeamName
     */
    public String getAwayTeamName() {
        return awayTeamName;
    }

    /**
     * 
     * @param awayTeamName
     *     The awayTeamName
     */
    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    /**
     * 
     * @return
     *     The result
     */
    public Result getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    public void setResult(Result result) {
        this.result = result;
    }

}
