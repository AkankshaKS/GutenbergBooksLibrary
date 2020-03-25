package com.gutenbergbookslibrary.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Formats implements Parcelable
{

    @SerializedName("application/x-mobipocket-ebook")
    @Expose
    private String applicationXMobipocketEbook;

    @SerializedName("text/plain; charset=utf-8")
    @Expose
    private String textPlainCharsetUtf8;

    @SerializedName("application/rdf+xml")
    @Expose
    private String applicationRdfXml;

    @SerializedName("text/plain; charset=iso-8859-1")
    @Expose
    private String textPlainCharsetIso88591;

    @SerializedName("application/epub+zip")
    @Expose
    private String applicationEpubZip;

    @SerializedName("image/jpeg")
    @Expose
    private String imageJpeg;

    @SerializedName("text/html; charset=utf-8")
    @Expose
    private String textHtmlCharsetUtf8;

    @SerializedName("application/zip")
    @Expose
    private String applicationZip;

    @SerializedName("text/plain; charset=us-ascii")
    @Expose
    private String textPlainCharsetUsAscii;

    @SerializedName("text/html")
    @Expose
    private String textHtml;

    @SerializedName("text/plain")
    @Expose
    private String textPlain;

    @SerializedName("text/html; charset=iso-8859-1")
    @Expose
    private String textHtmlCharsetIso88591;

    @SerializedName("text/html; charset=us-ascii")
    @Expose
    private String textHtmlCharsetUsAscii;

    @SerializedName("text/x-rst")
    @Expose
    private String textXRst;

    @SerializedName("application/octet-stream")
    @Expose
    private String applicationOctetStream;
    public final static Parcelable.Creator<Formats> CREATOR = new Creator<Formats>() {


        public Formats createFromParcel(Parcel in) {
            return new Formats(in);
        }

        public Formats[] newArray(int size) {
            return (new Formats[size]);
        }

    };

    protected Formats(Parcel in) {
        this.applicationXMobipocketEbook = ((String) in.readValue((String.class.getClassLoader())));
        this.textPlainCharsetUtf8 = ((String) in.readValue((String.class.getClassLoader())));
        this.applicationRdfXml = ((String) in.readValue((String.class.getClassLoader())));
        this.textPlainCharsetIso88591 = ((String) in.readValue((String.class.getClassLoader())));
        this.applicationEpubZip = ((String) in.readValue((String.class.getClassLoader())));
        this.imageJpeg = ((String) in.readValue((String.class.getClassLoader())));
        this.textHtmlCharsetUtf8 = ((String) in.readValue((String.class.getClassLoader())));
        this.applicationZip = ((String) in.readValue((String.class.getClassLoader())));
        this.textPlainCharsetUsAscii = ((String) in.readValue((String.class.getClassLoader())));
        this.textHtml = ((String) in.readValue((String.class.getClassLoader())));
        this.textPlain = ((String) in.readValue((String.class.getClassLoader())));
        this.textHtmlCharsetIso88591 = ((String) in.readValue((String.class.getClassLoader())));
        this.textHtmlCharsetUsAscii = ((String) in.readValue((String.class.getClassLoader())));
        this.textXRst = ((String) in.readValue((String.class.getClassLoader())));
        this.applicationOctetStream = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Formats() {
    }

    public String getApplicationXMobipocketEbook() {
        return applicationXMobipocketEbook;
    }

    public void setApplicationXMobipocketEbook(String applicationXMobipocketEbook) {
        this.applicationXMobipocketEbook = applicationXMobipocketEbook;
    }

    public String getTextPlainCharsetUtf8() {
        return textPlainCharsetUtf8;
    }

    public void setTextPlainCharsetUtf8(String textPlainCharsetUtf8) {
        this.textPlainCharsetUtf8 = textPlainCharsetUtf8;
    }

    public String getApplicationRdfXml() {
        return applicationRdfXml;
    }

    public void setApplicationRdfXml(String applicationRdfXml) {
        this.applicationRdfXml = applicationRdfXml;
    }

    public String getTextPlainCharsetIso88591() {
        return textPlainCharsetIso88591;
    }

    public void setTextPlainCharsetIso88591(String textPlainCharsetIso88591) {
        this.textPlainCharsetIso88591 = textPlainCharsetIso88591;
    }

    public String getApplicationEpubZip() {
        return applicationEpubZip;
    }

    public void setApplicationEpubZip(String applicationEpubZip) {
        this.applicationEpubZip = applicationEpubZip;
    }

    public String getImageJpeg() {
        return imageJpeg;
    }

    public void setImageJpeg(String imageJpeg) {
        this.imageJpeg = imageJpeg;
    }

    public String getTextHtmlCharsetUtf8() {
        return textHtmlCharsetUtf8;
    }

    public void setTextHtmlCharsetUtf8(String textHtmlCharsetUtf8) {
        this.textHtmlCharsetUtf8 = textHtmlCharsetUtf8;
    }

    public String getApplicationZip() {
        return applicationZip;
    }

    public void setApplicationZip(String applicationZip) {
        this.applicationZip = applicationZip;
    }

    public String getTextPlainCharsetUsAscii() {
        return textPlainCharsetUsAscii;
    }

    public void setTextPlainCharsetUsAscii(String textPlainCharsetUsAscii) {
        this.textPlainCharsetUsAscii = textPlainCharsetUsAscii;
    }

    public String getTextHtml() {
        return textHtml;
    }

    public void setTextHtml(String textHtml) {
        this.textHtml = textHtml;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }

    public String getTextHtmlCharsetIso88591() {
        return textHtmlCharsetIso88591;
    }

    public void setTextHtmlCharsetIso88591(String textHtmlCharsetIso88591) {
        this.textHtmlCharsetIso88591 = textHtmlCharsetIso88591;
    }

    public String getTextHtmlCharsetUsAscii() {
        return textHtmlCharsetUsAscii;
    }

    public void setTextHtmlCharsetUsAscii(String textHtmlCharsetUsAscii) {
        this.textHtmlCharsetUsAscii = textHtmlCharsetUsAscii;
    }

    public String getTextXRst() {
        return textXRst;
    }

    public void setTextXRst(String textXRst) {
        this.textXRst = textXRst;
    }

    public String getApplicationOctetStream() {
        return applicationOctetStream;
    }

    public void setApplicationOctetStream(String applicationOctetStream) {
        this.applicationOctetStream = applicationOctetStream;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(applicationXMobipocketEbook);
        dest.writeValue(textPlainCharsetUtf8);
        dest.writeValue(applicationRdfXml);
        dest.writeValue(textPlainCharsetIso88591);
        dest.writeValue(applicationEpubZip);
        dest.writeValue(imageJpeg);
        dest.writeValue(textHtmlCharsetUtf8);
        dest.writeValue(applicationZip);
        dest.writeValue(textPlainCharsetUsAscii);
        dest.writeValue(textHtml);
        dest.writeValue(textPlain);
        dest.writeValue(textHtmlCharsetIso88591);
        dest.writeValue(textHtmlCharsetUsAscii);
        dest.writeValue(textXRst);
        dest.writeValue(applicationOctetStream);
    }

    public int describeContents() {
        return 0;
    }

}