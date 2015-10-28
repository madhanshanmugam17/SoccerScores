
package com.madhan.soccerscores.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("soccerseason")
    @Expose
    private String soccerseason;

    /**
     * 
     * @return
     *     The self
     */
    public String getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The soccerseason
     */
    public String getSoccerseason() {
        return soccerseason;
    }

    /**
     * 
     * @param soccerseason
     *     The soccerseason
     */
    public void setSoccerseason(String soccerseason) {
        this.soccerseason = soccerseason;
    }

}
