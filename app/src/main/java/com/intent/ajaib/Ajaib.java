package com.intent.ajaib;

import android.os.Parcel;
import android.os.Parcelable;

public class Ajaib implements Parcelable {

    private String name, remarks, photo;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSistem() {
        return sistem;
    }

    public void setSistem(String sistem) {
        this.sistem = sistem;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getArsitek() {
        return arsitek;
    }

    public void setArsitek(String arsitek) {
        this.arsitek = arsitek;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    private String content, sistem, ukuran, arsitek, lokasi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Ajaib() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.content);
        dest.writeString(this.sistem);
        dest.writeString(this.ukuran);
        dest.writeString(this.arsitek);
        dest.writeString(this.lokasi);
    }

    protected Ajaib(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.content = in.readString();
        this.sistem = in.readString();
        this.ukuran = in.readString();
        this.arsitek = in.readString();
        this.lokasi = in.readString();
    }

    public static final Creator<Ajaib> CREATOR = new Creator<Ajaib>() {
        @Override
        public Ajaib createFromParcel(Parcel source) {
            return new Ajaib(source);
        }

        @Override
        public Ajaib[] newArray(int size) {
            return new Ajaib[size];
        }
    };
}
