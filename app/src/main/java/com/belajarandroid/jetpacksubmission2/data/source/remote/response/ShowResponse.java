package com.belajarandroid.jetpacksubmission2.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class ShowResponse implements Parcelable {
    private String showId;
    private String showPoster, showBackdrop;
    private String showTitle, showDate, showRate, showGenre, showLang;
    private String showOverview, showPopularity;

    public ShowResponse(String showId, String showPoster, String showBackdrop, String showTitle, String showDate, String showRate, String showGenre, String showLang, String showOverview, String showPopularity) {
        this.showId = showId;
        this.showPoster = showPoster;
        this.showBackdrop = showBackdrop;
        this.showTitle = showTitle;
        this.showDate = showDate;
        this.showRate = showRate;
        this.showGenre = showGenre;
        this.showLang = showLang;
        this.showOverview = showOverview;
        this.showPopularity = showPopularity;
    }

    private ShowResponse(Parcel in) {
        showId = in.readString();
        showPoster = in.readString();
        showBackdrop = in.readString();
        showTitle = in.readString();
        showDate = in.readString();
        showRate = in.readString();
        showGenre = in.readString();
        showLang = in.readString();
        showOverview = in.readString();
        showPopularity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(showId);
        dest.writeString(showPoster);
        dest.writeString(showBackdrop);
        dest.writeString(showTitle);
        dest.writeString(showDate);
        dest.writeString(showRate);
        dest.writeString(showGenre);
        dest.writeString(showLang);
        dest.writeString(showOverview);
        dest.writeString(showPopularity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ShowResponse> CREATOR = new Creator<ShowResponse>() {
        @Override
        public ShowResponse createFromParcel(Parcel in) {
            return new ShowResponse(in);
        }

        @Override
        public ShowResponse[] newArray(int size) {
            return new ShowResponse[size];
        }
    };

    public String getShowId() {
        return showId;
    }

    public String getShowPoster() {
        return showPoster;
    }

    public String getShowBackdrop() {
        return showBackdrop;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public String getShowDate() {
        return showDate;
    }

    public String getShowRate() {
        return showRate;
    }

    public String getShowGenre() {
        return showGenre;
    }

    public String getShowLang() {
        return showLang;
    }

    public String getShowOverview() {
        return showOverview;
    }

    public String getShowPopularity() {
        return showPopularity;
    }
}
