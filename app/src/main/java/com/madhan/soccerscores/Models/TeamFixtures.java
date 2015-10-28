
package com.madhan.soccerscores.Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamFixtures {

    @SerializedName("_links")
    @Expose
    private List<Link> Links = new ArrayList<Link>();
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = new ArrayList<Fixture>();

    /**
     * 
     * @return
     *     The Links
     */
    public List<Link> getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(List<Link> Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The fixtures
     */
    public List<Fixture> getFixtures() {
        return fixtures;
    }

    /**
     * 
     * @param fixtures
     *     The fixtures
     */
    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}
